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
    /**
     * si hay fichas disponles, agrega fichas al atril del jugador hasta que este llegue a 7 unidades
     *
     */
    public void completarAtril(FichasTotales bolsa) {
        while(atril.size() <= 7 && bolsa.getCantidadFichas() > 0){
            atril.add(bolsa.agarrarFicha());
        }
    }

    public List<String> consultarAtril(){
        List<String> valoresAtril = new ArrayList<>();
        for(Ficha ficha : atril){
            valoresAtril.add(ficha.getLetra());
        }
        return valoresAtril;
    }

    public void sumarPuntos(int puntaje){
        this.puntaje += puntaje;
    }

    public List<Ficha> jugar(List<Integer> posiciones){
        List<Ficha> fichasJugadas = new ArrayList<>();

        if(!atril.isEmpty()){
            for(Integer posicion : posiciones){
                if(atril.size() >= posicion && posicion >= 0){
                    fichasJugadas.add(atril.remove(posicion.intValue()));
                }
            }
        }
        return fichasJugadas;
    }

    public boolean atrilEsVacio(){
        return atril.isEmpty();
    }
}
