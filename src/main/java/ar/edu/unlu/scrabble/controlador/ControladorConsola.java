package ar.edu.unlu.scrabble.controlador;

import ar.edu.unlu.scrabble.modelo.*;
import ar.edu.unlu.scrabble.observer.Observable;
import ar.edu.unlu.scrabble.observer.Observador;
import ar.edu.unlu.scrabble.vista.VistaConsola;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorConsola implements Observador {
    private Partida modelo;
    private VistaConsola vista;


    public ControladorConsola(Partida modelo, VistaConsola vista){
        this.modelo = modelo;
        this.vista = vista;
        this.modelo.agregarObservador(this);
    }

    public void iniciar(){
        ManejadorJugadores jugadores = ManejadorJugadores.getInstance();
        ManejadorTurno turnos = ManejadorTurno.getInstance();
        while (true){
            vista.mostrarMenu();
            int opcion = vista.obtenerOpcionInt();

            switch (opcion){
                case 1:
                    modelo.iniciarPartida(vista.configurarPartida());
                    juego();
                    break;
                case 2:
                    vista.mostrarSalida();
                    return;
                default:
                    vista.mostrarMensaje("Opcion no valida");
                    break;
            }
        }
    }

    public void juego(){
        ManejadorTurno turnos = ManejadorTurno.getInstance();
        Jugador jugador;
        boolean primerTurno = true;
        boolean jugadaValida = true;

        while (true){
            jugador = turnos.getJugadorTurno();
            vista.mostrarInfoJugador(jugador);
            vista.mostrarTablero();
            vista.mostrarAtril(modelo.verAtrilJugador(jugador.getNombre()));
            //pedimos las fichas que quieren jugar
            if(primerTurno){//solo puede jugar en el medio
                    jugada(true, jugador);
                    //TODO: dar la opcion de pasar
                    primerTurno=false;
                }
            else {
                jugada(false, jugador);
                //Todo: dar la opcion de pasar
            }
            //termino la partida?


//            if(){
//                //mostramos ganadores
//               break;
//            }
            modelo.pasar();
            //cambio de turno

            }
            //pedimos las posiciones
            //modelo.jugarPalabra();//juega
        }

        public void jugada(boolean primerTurno, Jugador jugador) {
            boolean jugadaValida = true;
            Map<Integer, List<Integer>> jugada = new HashMap<>();
            List<List<Integer>> listaDeCoordenadas;
            Orientacion orientacionDetectada = null;
            while (jugadaValida) {
                jugada = vista.pedirJugada(jugador, primerTurno);
                listaDeCoordenadas = new ArrayList<>(jugada.values());
                orientacionDetectada = modelo.determinarOrientacion(listaDeCoordenadas);
                if (!(orientacionDetectada == null)) {
                    jugadaValida = false;
                }
            }
            modelo.jugarPalabra(jugada,orientacionDetectada);
        }

    @Override
    public void actualizar() {

    }
}

