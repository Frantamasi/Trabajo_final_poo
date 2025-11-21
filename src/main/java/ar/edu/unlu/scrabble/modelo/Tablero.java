package ar.edu.unlu.scrabble.modelo;

public class Tablero {
    private Casillero[][] tablero = new Casillero[15][15];

    public Tablero(){
        tablero[0][0] = new CasilleroRojo();
        tablero[0][3] = new CasilleroCeleste();
    }

}
