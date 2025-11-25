package ar.edu.unlu.scrabble.modelo;

import ar.edu.unlu.scrabble.exception.JugadorNoEncontrado;

import java.util.HashMap;
import java.util.Map;

public class ManejadorJugadores {
    private Map<String, Jugador> jugadores = new HashMap<>();
    private static ManejadorJugadores instancia = null;
    private ManejadorJugadores(){
    }

    public static ManejadorJugadores getInstance() {
        if(instancia == null) instancia = new ManejadorJugadores();
        return instancia;
    }

    public Jugador getJugador(String nombre){
        if(!jugadores.containsKey(nombre)){
            throw new JugadorNoEncontrado("El jugador "+nombre + " no se encuentra en la lista de jugadores");
        }
        return jugadores.get(nombre);
    }

    public boolean existeJugador(String nombre){
        return jugadores.containsKey(nombre);
    }

    public void addJugador(Jugador jugador){
        jugadores.put(jugador.getNombre(),jugador);
    }
}
