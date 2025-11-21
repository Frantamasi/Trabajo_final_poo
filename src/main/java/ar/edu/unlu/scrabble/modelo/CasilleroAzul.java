package ar.edu.unlu.scrabble.modelo;

public class CasilleroAzul extends Casillero{

    /**
     * triplica el valor de la ficha en dicha posicion
     * @return
     */
    @Override
    public int getPuntaje() {
        return super.getPuntaje()*3;
    }
}
