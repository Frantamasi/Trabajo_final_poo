package ar.edu.unlu.scrabble.modelo;

import java.util.List;

public class Casillero {
    private TipoCasillero tipo;
    private Ficha ficha;
    private Coordenada coordenada;

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

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
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
    public Coordenada getPosicion(){
        return coordenada;
    }

    public boolean estaOcupado(){
        return ficha == null;
    }
}
