package ar.edu.unlu.scrabble.modelo;

import ar.edu.unlu.scrabble.exception.PalabraNoAlineada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Palabra {
    private List<Casillero> letras = new ArrayList<>();
    private Orientacion orientacion;
    private int multiplicador = 1;
    private int puntaje = 0;


    public Palabra(List<Casillero> casilleros, Orientacion orientacion) throws PalabraNoAlineada{
        this.orientacion = orientacion;
        try {
            iniciar(casilleros);
        } catch (PalabraNoAlineada e) {
            throw new PalabraNoAlineada("La palabra ingresada no esta alineada");
        }
    }

    /**
     * valida que la palabra este alineada en el tablero
     * @param casilleros
     */
    private void iniciar(List<Casillero> casilleros) throws PalabraNoAlineada{
        Casillero actual = null;
        Iterator<Casillero> iterator = casilleros.iterator();
        if(iterator.hasNext()){
            actual = iterator.next();
        }
        while(iterator.hasNext()){
            Casillero siguiente = iterator.next();
            if(!validarSiguiente(actual,siguiente)){
                throw new PalabraNoAlineada("La palabra ingresada no esta alineada");
            }
            addLetra(actual);
            actual = siguiente;
            if(!iterator.hasNext()){
                addLetra(actual);
            }
        }
    }

    private boolean validarSiguiente(Casillero letra, Casillero letraSiguiente){
        switch (orientacion){
            case VERTICAL -> {  //si la posicion de la columna es la misma y la fila es la siguiente
               return (letra.getPosicion().getValorColumna() == letraSiguiente.getPosicion().getValorColumna()) &&
                        (letra.getPosicion().getValorFila() == (letraSiguiente.getPosicion().getValorFila()-1));
            }
            case HORIZONTAL -> {
                return (letra.getPosicion().getValorFila() == letraSiguiente.getPosicion().getValorFila()) &&
                        (letra.getPosicion().getValorColumna() == (letraSiguiente.getPosicion().getValorColumna()-1));
            }
            default -> {
                return false;
            }
        }

    }

    private void addLetra(Casillero letra){
        puntaje += letra.getPuntajeCasillero();  //suma puntaje de la letra
        multiplicador *= letra.getMultiplicadorPalabra();
        letras.add(letra);
    }
    /**
     *
     * @return el puntaje final de la palabra, con su multiplicador
     */
    public int getPuntaje() {
        return puntaje * multiplicador;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public List<Coordenada> getListaCoordenadas(){
        List<Coordenada> coordenadas = new ArrayList<>();
        for(Casillero letra : letras){
            coordenadas.add(letra.getPosicion());
        }
        return coordenadas;
    }

    /**
     *
     * @return el string de la palabra
     */
    @Override
    public String toString() {
        StringBuilder palabra = new StringBuilder();
        for(Casillero casillero : letras){
            palabra.append(casillero.getFicha().getLetra());
        }
        return palabra.toString();
    }
}
