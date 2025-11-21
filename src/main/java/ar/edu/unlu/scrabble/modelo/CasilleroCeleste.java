package ar.edu.unlu.scrabble.modelo;

public class CasilleroCeleste extends Casillero{
    private int puntuacion;

    /**
     * duplica el valor de la ficha en dicha posicion
     * @return
     */
    @Override
    public int getPuntaje() {
        return super.getPuntaje()*2;
    }
}
