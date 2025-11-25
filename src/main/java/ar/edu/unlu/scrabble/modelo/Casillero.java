package ar.edu.unlu.scrabble.modelo;

import ar.edu.unlu.scrabble.Interfaces.ICasillero;
import ar.edu.unlu.scrabble.Interfaces.ICoordenada;
import ar.edu.unlu.scrabble.Interfaces.IFicha;

import java.util.List;

public class Casillero implements ICasillero {
    private TipoCasillero tipo;
    private IFicha ficha;
    private ICoordenada coordenada;

    public Casillero(TipoCasillero tipo, Coordenada coordenada){
        this.ficha = null;
        this.tipo = tipo;
        this.coordenada = coordenada;
    }

    public TipoCasillero getTipo() {
        return tipo;
    }

    public void setTipo(TipoCasillero tipo) {
        this.tipo = tipo;
    }

    public IFicha getFicha() {
        return ficha;
    }

    public void setFicha(IFicha ficha) {
        this.ficha = ficha;
    }

    /**
     * multiplica el puntaje del casillero y el puntaje de la letra
     * @return
     */
    public int getPuntajeCasillero(){
        return ficha.getPuntaje() * tipo.getMultiplicadorLetra();
    }

    public int getMultiplicadorPalabra(){
        return tipo.getMultiplicadorPalabra();
    }
    /**
     *
     * @return obtiene la posicion del casillero en el tablero
     */
    public ICoordenada getPosicion(){
        return coordenada;
    }

    public boolean estaOcupado(){
        return ficha != null;
    }
}
