package ar.edu.unlu.scrabble.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Partida {
    private ManejadorTurno manejadorTurno;

    public Partida(){
        manejadorTurno = new ManejadorTurno();
    }
    public void jugarPalabra(Map<Integer,List<Integer>> jugada){

        Tablero tablero = Tablero.getInstance();
        Jugador jugador = manejadorTurno.getJugadorTurno();
        List<Ficha> jugadaDeFichas = jugador.jugar(jugada.keySet().stream().toList());

        List<Coordenada> coordenadasJugadas = jugada.values().stream().map((posiciones)->{
            return new Coordenada(posiciones.removeFirst().intValue(), posiciones.removeFirst().intValue());
        }).toList();

        //List<Casillero> casillerosAUtilizar =
    }
}
