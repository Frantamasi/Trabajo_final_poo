package ar.edu.unlu.scrabble.modelo;

public enum TipoCasillero {
    PUNTAJE_NORMAL(1,1), PUNTAJE_DOBLE_LETRA(2,1),
    PUNTAJE_TRIPLE_LETRA(3,1), PUNTAJE_DOBLE_PALABRA(1,2),
    PUNTAJE_TRIPLE_PALABRA(1,3);
    //(a,b) argumentos que se le pasan al constructor para cada uno de los casos
    private final int multiplicadorLetra;
    private final int multiplicadorPalabra;

    TipoCasillero(int multiplicadorLetra, int multiplicadorPalabra) {
        this.multiplicadorLetra = multiplicadorLetra;
        this.multiplicadorPalabra = multiplicadorPalabra;
    }

    public int getMultiplicadorPalabra() {
        return multiplicadorPalabra;
    }

    public int getMultiplicadorLetra() {
        return multiplicadorLetra;
    }
}
