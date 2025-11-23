package ar.edu.unlu.scrabble.modelo;

import java.io.IOException;
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

    /**
     * dada una palabra candidata obtiene todas las palabras formada en la posible jugada
     * @param palabra
     * @return this para generar una concatenacion de llamada de metodos
     */
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
            }
        }
        return this;
    }

    public boolean validar(){
        if(palabrasFormadas.isEmpty()) return false;
        Diccionario diccionario = null;
        try{
            diccionario = Diccionario.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(Palabra palabra : palabrasFormadas){
            if(!diccionario.verificarPalabra(palabra.toString())){
                return false;
            }
        }
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
