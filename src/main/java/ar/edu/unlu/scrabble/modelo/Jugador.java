package ar.edu.unlu.scrabble.modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private int puntaje;
    private String nombre;
    private List<Ficha> atril = new ArrayList<>();


    public Jugador(String nombre) {
        setNombre(nombre);
        setPuntaje(0);
        this.atril = new ArrayList<>(atril);
    }

    public List<Ficha> getAtril() {
        return atril;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
