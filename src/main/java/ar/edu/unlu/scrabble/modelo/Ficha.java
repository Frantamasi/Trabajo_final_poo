package ar.edu.unlu.scrabble.modelo;

public class Ficha {
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

