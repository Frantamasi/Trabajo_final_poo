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

        List<Coordenada> coordenadas = palabraJugada.getListaCoordenadas();
        Orientacion orientacion = palabraJugada.getOrientacion();
        Tablero tablero = Tablero.getInstance();

        for(Coordenada coordenada : coordenadas){
            switch (orientacion){
                case VERTICAL ->{
                    if(tablero.casilleroOcupado(tablero.getColumnaAnterior(coordenada))
                            || tablero.casilleroOcupado(tablero.getColumnaSiguiente(coordenada))){   //si el casillero de la izquierda o derecha esta ocupado
                        palabrasFormadas.add(tablero.getPalabra(coordenada, Orientacion.HORIZONTAL));
                    }
                }
                case HORIZONTAL -> {
                    if(tablero.casilleroOcupado(tablero.getFilaAnterior(coordenada))
                            || tablero.casilleroOcupado(tablero.getFilaSiguiente(coordenada))){   //si el casillero de la izquierda o derecha esta ocupado
                        palabrasFormadas.add(tablero.getPalabra(coordenada, Orientacion.VERTICAL));
                    }
                }
                default -> {
                    break;  //exception falta de horientacion sexcual TODO
                }
            }
        }

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
