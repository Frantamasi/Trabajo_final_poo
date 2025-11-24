package ar.edu.unlu.scrabble.controlador;

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
        while (true){
            vista.mostrarMenu();
            int opcion = vista.obtenerOpcion();

            switch (opcion){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;

                case 0:
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
