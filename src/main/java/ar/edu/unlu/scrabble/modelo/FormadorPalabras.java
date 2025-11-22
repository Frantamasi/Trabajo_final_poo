package ar.edu.unlu.scrabble.modelo;

import java.util.List;
import java.util.ArrayList;

public class FormadorPalabras {
    private List<Palabra> palabrasFormadas = new ArrayList<Palabra>();
    private static FormadorPalabras instancia = null;
    private Palabra palabraJugada;

    public static FormadorPalabras getInstance() {
        if(instancia == null) instancia = new FormadorPalabras();
        return instancia;
    }
    private FormadorPalabras(){}

    public FormadorPalabras formarPalabras(Palabra palabra){
        palabrasFormadas.clear();
        palabraJugada = palabra;


        return this;
    }

    public boolean validar(Palabra palabra){
        return true;
    }

    public int getPuntaje(){
        int puntaje = 0;
        for(Palabra palabra : palabrasFormadas){
            puntaje += palabra.getPuntaje();
        }
        return puntaje;
    }
}
