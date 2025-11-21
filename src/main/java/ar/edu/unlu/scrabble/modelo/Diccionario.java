package ar.edu.unlu.scrabble.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Diccionario {
    private Set<String> diccionario = new HashSet<>();

    public Diccionario() throws IOException {
        cargarDiccionario();
    }

    /**
     * carga el diccionario completo en el hashset
     * @throws IOException
     */
    public void cargarDiccionario() throws IOException {
        String palabra;
        BufferedReader lector = new BufferedReader(new FileReader("diccionario.txt"));
        while ((palabra = lector.readLine()) != null){
            diccionario.add(palabra.trim().toUpperCase());  //agrega la palabra al diccionario
        }
    }

    /**
     * recibe la jugada del jugador y verifica que exista en el diccionario
     * @param palabra
     * @return true si existe
     */
    public boolean verificarPalabra(String palabra){
        return diccionario.contains(palabra);
    }
}
