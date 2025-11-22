package ar.edu.unlu.scrabble.modelo;

import java.util.List;
import java.util.ArrayList;

public class Coordenada {
    int fila;
    int columna;

    public Coordenada(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public List<Integer> getCordenada(){
        ArrayList<Integer> coordenadas = new ArrayList<>();
        coordenadas.add(getFila());
        coordenadas.add(getColumna());
        return coordenadas;
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }
}
