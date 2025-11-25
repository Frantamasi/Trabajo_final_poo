package ar.edu.unlu.scrabble;

import ar.edu.unlu.scrabble.controlador.ControladorConsola;
import ar.edu.unlu.scrabble.modelo.Diccionario;
import ar.edu.unlu.scrabble.modelo.Partida;
import ar.edu.unlu.scrabble.vista.VistaConsola;

import java.io.IOException;

public class ScrabbleApp {
    public static void main(String[] args) throws IOException {
    Partida modeleo = new Partida();

        VistaConsola vista = new VistaConsola();
        ControladorConsola controlador = new ControladorConsola(modeleo, vista);

        controlador.iniciar();


    }

}
