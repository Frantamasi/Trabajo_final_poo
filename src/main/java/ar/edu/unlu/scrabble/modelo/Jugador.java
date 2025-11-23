package ar.edu.unlu.scrabble.modelo;

import ar.edu.unlu.scrabble.Interfaces.IFicha;

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
    public void completarAtril(BolsaDeFichas bolsa) {
        while(atril.size() <= 7 && bolsa.getCantidadFichas() > 0){
            atril.add(bolsa.agarrarFicha());
        }
    }

    public List<IFicha> consultarAtril(){
        List<IFicha> valoresAtril = new ArrayList<>();
        atril.forEach((ficha)->{
            valoresAtril.add(ficha);
        });
        return valoresAtril;
    }

    public void sumarPuntos(int puntaje){
        this.puntaje += puntaje;
    }

    /**
     * dada una lista de posiciones (fichas del atril) remueve las fichas en dicha posicion y las retorna
     * @param posiciones
     * @return
     */
    public List<Ficha> jugar(List<Integer> posiciones){
        List<Ficha> fichasJugadas = new ArrayList<>();

        if(!atril.isEmpty()){
            for(Integer posicion : posiciones){
                if(atril.size() >= posicion && posicion >= 0){
                    fichasJugadas.add(atril.remove(posicion.intValue()));   //TODO: verificar que saque la ficha especificada a partir de la segunda iteracion
                }
            }
        }
        return fichasJugadas;
    }

    public Ficha jugar(int posicion){
        if(!atrilEsVacio()){
            if(atril.size() >= posicion && posicion >= 0){
                return atril.remove(posicion);
            }
        }
        return null;    //TODO: agregar excepcion de ficha no existente
    }

    public boolean atrilEsVacio(){
        return atril.isEmpty();
    }

    public int getPuntajeFinal(){
        int puntajeFinal = puntaje;
        for(Ficha ficha : atril){
            puntajeFinal -= ficha.getPuntaje();
        }
        return puntajeFinal;
    }

}
