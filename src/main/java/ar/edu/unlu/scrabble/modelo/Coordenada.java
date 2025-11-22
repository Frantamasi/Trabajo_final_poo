package ar.edu.unlu.scrabble.modelo;

public class Coordenada {
    int fila;
    int columna;

    public Coordenada(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int getValorFila(){
        return fila;
    }

    public int getValorColumna(){
        return columna;
    }
}
