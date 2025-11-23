package ar.edu.unlu.scrabble.modelo;

import ar.edu.unlu.scrabble.exception.CoordenadaInvalida;

public class Coordenada {
    int fila;
    int columna;

    public Coordenada(int fila, int columna) throws CoordenadaInvalida {
        if(fila < 0 || fila > 14 || columna < 0 || columna > 14){
            throw new CoordenadaInvalida("La coordenada ingresa no es valida");
        }
        this.fila = fila;
        this.columna = columna;
    }

    public int getValorFila(){
        return fila;
    }

    public int getValorColumna(){
        return columna;
    }

    /**
     *
     * @param coordenada
     * @return
     */
    public static boolean coordenadaExiste(Coordenada coordenada){
        return coordenada != null;
    }
    //TODO implementar crear coordeanas validas isvalid
}
