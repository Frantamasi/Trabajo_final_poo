package ar.edu.unlu.scrabble.modelo;

import java.util.ArrayList;

public class Partida {
    private Tablero tablero;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private FichasTotales bolsaDeFichas;
    private Diccionario diccionario;
    private int turnosSalteados;

    public void inicioPartida(){

    }
    public void agregarJugadores(){

    }

    /**
     * si hay fichas disponles, agrega fichas al atril del jugador hasta que este llegue a 7 unidades
     *
     */
    public void completarAtril(Jugador jugador) {

        //jugador.getAtril().completate(bolsaDeFichas);
        while(jugador.getAtril().size() <= 7){
            if(bolsaDeFichas.getCantidadFichas() > 0){
                jugador.getAtril().add(bolsaDeFichas.agarrarFicha());
            }
            else{
                break;  //chequear reglas si tiene que terminar la partida
            }
        }
    }
}
