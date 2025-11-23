package ar.edu.unlu.scrabble.modelo;

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


    public void addJugador(Jugador jugador){
        jugadores.put(jugador.getNombre(),jugador);
    }
}
