package ar.edu.unlu.scrabble.modelo;

import java.util.ArrayList;
import java.util.List;

public class Palabra {
    private List<Casillero> letras = new ArrayList<>();
    private Orientacion orientacion;
    private int multiplicador = 1;
    private int puntaje = 0;


    public Palabra(List<Casillero> casilleros, Orientacion orientacion){
        this.orientacion = orientacion;
        for(Casillero casilla : casilleros){
            addLetra(casilla);
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
