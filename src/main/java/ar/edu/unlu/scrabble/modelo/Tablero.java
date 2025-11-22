package ar.edu.unlu.scrabble.modelo;

public class Tablero {
    private Casillero[][] tablero = new Casillero[15][15];
    private static Tablero instancia = null;

    private Tablero(){
        inicializarTablero();
    }

    public static Tablero getInstance() {
        if(instancia == null){
            instancia = new Tablero();
        }
        return instancia;
    }

    public void inicializarTablero(){
        //llenar el tablero de casilleros vacios
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                tablero[i][j] = new Casillero(TipoCasillero.PUNTAJE_NORMAL);
            }
        }
        //pabalabras tiples
        casillaPalabraTriple();
        //pabalabras doble
        casillaPalabraDoble();
        //letra tiples
        casillaLetraTriple();
        //letras dobles
        casillaLetraDoble();
    }
    public void casillaPalabraTriple(){
        tablero[0][0] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA);
        tablero[0][7] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA);
        tablero[0][14] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA);
        tablero[7][0] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA);
        tablero[7][14] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA);
        tablero[14][0] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA);
        tablero[14][7] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA);
        tablero[14][14] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA);
    }
    public void casillaPalabraDoble(){
        for (int i = 1; i < 5; i++) {   //superior izquierda
            tablero[i][i] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_PALABRA);
        }
        for (int i = 13; i > 9; i--) {  //inferior derecha
            tablero[i][i] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_PALABRA);
        }
        int j = 13;
        for (int i = 1; i < 5; i++) {   //superior derecha
            tablero[i][j] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_PALABRA);
            j--;
        }
        j = 13;
        for (int i = 1; i < 5; i++) {   //inferior izquierda
            tablero[j][i] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_PALABRA);
            j--;
        }
    }
    public void casillaLetraTriple(){
        tablero[1][5] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
        tablero[1][9] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
        //
        tablero[5][1] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
        tablero[5][5] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
        tablero[5][9] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
        tablero[5][13] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
        //
        tablero[9][1] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
        tablero[9][5] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
        tablero[9][9] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
        tablero[9][13] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
        //
        tablero[13][5] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
        tablero[13][9] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA);
    }
    public void casillaLetraDoble(){

        tablero[0][3] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[0][11] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        //
        tablero[2][6] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[2][8] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        //
        tablero[3][0] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[3][7] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[3][14] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        //
        tablero[6][2] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[6][6] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[6][8] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[6][12] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        //
        tablero[7][3] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[7][11] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        //
        tablero[8][2] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[8][6] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[8][8] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[8][12] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        //
        tablero[11][0] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[11][7] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[11][14] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        //
        tablero[12][6] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[12][8] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        //
        tablero[14][3] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
        tablero[14][11] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA);
    }

    /**
     *
     * @param fila
     * @param col
     * @return
     */
    public boolean getCasillero(int fila, int col) {
        if(fila >= 0 && fila < 15 && col >= 0 && col < 15){
            if(tablero[fila][col] == null){ //significa que el casillero esta vacio
                return true;
            }
            else{
                return false;
            }
        }
        return false;
        //lanzar excepcion
    }
}
