package ar.edu.unlu.scrabble.modelo;

import ar.edu.unlu.scrabble.Interfaces.IFicha;

public class Ficha implements IFicha {
    private String letra;
    private int puntaje;


    public Ficha(String letra, int puntaje) {
        this.letra = letra;
        this.puntaje = puntaje;
    }

    public String getLetra() {
        return letra;
    }

    public int getPuntaje() {
        return puntaje;
    }
}

