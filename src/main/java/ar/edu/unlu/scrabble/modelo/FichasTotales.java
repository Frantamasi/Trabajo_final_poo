package ar.edu.unlu.scrabble.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FichasTotales {
    private List<Ficha> fichas = new ArrayList<>();
    private int cantidadFichas;

    private static FichasTotales instancia = null;

    public static FichasTotales getInstance() {
        if(instancia == null){
            instancia = new FichasTotales();
        }
        return instancia;
    }

    /**
     * Por cada letra crea una cantidad de fichas especifica y la agrega a la lista
     * luego mezcla las fichas
     */
    private FichasTotales(){
        for (int i = 0; i < 12; i++) fichas.add(new Ficha("A", 1)); for (int i = 0; i < 12; i++) fichas.add(new Ficha("E", 1));
        for (int i = 0; i < 9; i++)  fichas.add(new Ficha("O", 1)); for (int i = 0; i < 6; i++)  fichas.add(new Ficha("S", 1));
        for (int i = 0; i < 7; i++)  fichas.add(new Ficha("I", 1)); for (int i = 0; i < 7; i++)  fichas.add(new Ficha("U", 1));
        for (int i = 0; i < 5; i++)  fichas.add(new Ficha("N", 1)); for (int i = 0; i < 5; i++)  fichas.add(new Ficha("R", 1));
        for (int i = 0; i < 5; i++)  fichas.add(new Ficha("D", 2)); for (int i = 0; i < 4; i++)  fichas.add(new Ficha("L", 1));
        for (int i = 0; i < 4; i++)  fichas.add(new Ficha("T", 1)); for (int i = 0; i < 4; i++)  fichas.add(new Ficha("C", 3));
        for (int i = 0; i < 3; i++)  fichas.add(new Ficha("M", 3)); for (int i = 0; i < 2; i++)  fichas.add(new Ficha("G", 2));
        for (int i = 0; i < 2; i++)  fichas.add(new Ficha("B", 3)); for (int i = 0; i < 2; i++)  fichas.add(new Ficha("P", 3));
        fichas.add(new Ficha("F", 4)); fichas.add(new Ficha("H", 4)); fichas.add(new Ficha("V", 4));
        fichas.add(new Ficha("Y", 4)); fichas.add(new Ficha("W", 4)); fichas.add(new Ficha("Q", 5));
        fichas.add(new Ficha("J", 8)); fichas.add(new Ficha("Ñ", 8)); fichas.add(new Ficha("X", 8));
        fichas.add(new Ficha("K", 8)); fichas.add(new Ficha("Z", 10));

        Collections.shuffle(fichas);
    }

    public int getCantidadFichas() {
        return cantidadFichas;
    }

    public boolean esVacia(){
        return getCantidadFichas() == 0;
    }
    /**
     * Saca una ficha de la lista de fichas
     * @return retorna la primera ficha. en caso de no haber mas fichas, retorna null
     */
    public Ficha agarrarFicha(){
        if(fichas.isEmpty()) return null;
        return fichas.removeFirst();
    }

}
