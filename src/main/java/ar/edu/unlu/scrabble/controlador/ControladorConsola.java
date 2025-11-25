package ar.edu.unlu.scrabble.controlador;

import ar.edu.unlu.scrabble.modelo.ManejadorJugadores;
import ar.edu.unlu.scrabble.modelo.ManejadorTurno;
import ar.edu.unlu.scrabble.modelo.Partida;
import ar.edu.unlu.scrabble.observer.Observable;
import ar.edu.unlu.scrabble.observer.Observador;
import ar.edu.unlu.scrabble.vista.VistaConsola;

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
                    vista.mostrarTablero();
                    vista.mostrarAtril(modelo.verAtrilJugador(turnos.getJugadorTurno().getNombre()));
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

    @Override
    public void actualizar() {

    }
}
