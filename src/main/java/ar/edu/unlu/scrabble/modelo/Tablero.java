package ar.edu.unlu.scrabble.modelo;

import ar.edu.unlu.scrabble.Interfaces.ICasillero;
import ar.edu.unlu.scrabble.Interfaces.ICoordenada;
import ar.edu.unlu.scrabble.Interfaces.ITableroPublico;
import ar.edu.unlu.scrabble.exception.CasilleroOcupado;
import ar.edu.unlu.scrabble.exception.CoordenadaInvalida;
import ar.edu.unlu.scrabble.exception.JugadaInvalida;
import ar.edu.unlu.scrabble.exception.PalabraNoAlineada;

import java.util.ArrayList;
import java.util.List;

public class Tablero implements ITableroPublico {
    private ICasillero[][] casilleros = new Casillero[15][15];
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
    //TODO: poner estos metodos en privado
    public void inicializarTablero(){
        //llenar el tablero de casilleros vacios
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                casilleros[i][j] = new Casillero(TipoCasillero.PUNTAJE_NORMAL,new Coordenada(i,j));

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
        casilleros[0][0] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA,new Coordenada(0,0));
        casilleros[0][7] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA,new Coordenada(0,7));
        casilleros[0][14] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA,new Coordenada(0,14));
        casilleros[7][0] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA,new Coordenada(7,0));
        casilleros[7][14] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA,new Coordenada(7,14));
        casilleros[14][0] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA,new Coordenada(14,0));
        casilleros[14][7] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA,new Coordenada(14,7));
        casilleros[14][14] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_PALABRA,new Coordenada(14,14));
    }
    public void casillaPalabraDoble(){
        for (int i = 1; i < 5; i++) {   //superior izquierda
            casilleros[i][i] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_PALABRA,new Coordenada(i,i));
        }
        for (int i = 13; i > 9; i--) {  //inferior derecha
            casilleros[i][i] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_PALABRA,new Coordenada(i,i));
        }
        int j = 13;
        for (int i = 1; i < 5; i++) {   //superior derecha
            casilleros[i][j] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_PALABRA,new Coordenada(i,j));
            j--;
        }
        j = 13;
        for (int i = 1; i < 5; i++) {   //inferior izquierda
            casilleros[j][i] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_PALABRA,new Coordenada(j,i));
            j--;
        }
    }
    public void casillaLetraTriple(){
        casilleros[1][5] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(1,5));
        casilleros[1][9] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(1,9));
        //
        casilleros[5][1] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(5,1));
        casilleros[5][5] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(5,5));
        casilleros[5][9] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(5,9));
        casilleros[5][13] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(5,13));
        //
        casilleros[9][1] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(9,1));
        casilleros[9][5] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(9,5));
        casilleros[9][9] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(9,9));
        casilleros[9][13] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(9,13));
        //
        casilleros[13][5] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(13,5));
        casilleros[13][9] = new Casillero(TipoCasillero.PUNTAJE_TRIPLE_LETRA,new Coordenada(13,9));
    }
    public void casillaLetraDoble(){

        casilleros[0][3] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(0,3));
        casilleros[0][11] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(0,11));
        //
        casilleros[2][6] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(2,6));
        casilleros[2][8] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(2,8));
        //
        casilleros[3][0] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(3,0));
        casilleros[3][7] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(3,7));
        casilleros[3][14] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(3,14));
        //
        casilleros[6][2] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(6,2));
        casilleros[6][6] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(6,6));
        casilleros[6][8] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(6,8));
        casilleros[6][12] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(6,12));
        //
        casilleros[7][3] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(7,3));
        casilleros[7][11] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(7,11));
        //
        casilleros[8][2] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(8,2));
        casilleros[8][6] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(8,6));
        casilleros[8][8] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(8,8));
        casilleros[8][12] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(8,12));
        //
        casilleros[11][0] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(11,0));
        casilleros[11][7] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(11,7));
        casilleros[11][14] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(11,14));
        //
        casilleros[12][6] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(12,6));
        casilleros[12][8] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(12,8));
        //
        casilleros[14][3] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(14,3));
        casilleros[14][11] = new Casillero(TipoCasillero.PUNTAJE_DOBLE_LETRA,new Coordenada(14,11));
    }

    /**
     *
     * @param
     * @param
     * @return
     */
    public ICasillero getCasillero(ICoordenada coordenada) {
        return casilleros[coordenada.getValorFila()][coordenada.getValorColumna()];
    }

    public void setCasilleros(List<ICasillero> casilleros){
        casilleros.forEach((casillero)->{
            ICoordenada coordenada = casillero.getPosicion();
            this.casilleros[coordenada.getValorFila()][coordenada.getValorColumna()] = casillero;
        });
    }

    /**
     * dada una coordena y una orientacion, va a buscar la palabra que se encuentre en dicha cooredenada
     * @param coordenada
     * @param orientacion
     * @return palabra en el tablero
     */
    public Palabra getPalabra(ICoordenada coordenada, Orientacion orientacion) {
        //tal casilla y tal orientacion
        List<ICasillero> casilleros = new ArrayList<>();
        ICoordenada coordenadaActual = coordenada;
        ICoordenada coordenadaAnterior = coordenada; //ultima coordenada que tiene una ficha
        switch (orientacion) {
            case VERTICAL -> {
                while (Coordenada.coordenadaExiste(coordenadaActual) && casilleroOcupado(coordenadaActual)) {   //verificamos que la instancia de la coordenada exista
                    coordenadaAnterior = coordenadaActual;
                    coordenadaActual = this.getFilaAnterior(coordenadaActual);
                }
                coordenadaActual = coordenadaAnterior;
                while (Coordenada.coordenadaExiste(coordenadaActual) && casilleroOcupado(coordenadaActual)) {   //baja hasta la ultima ficha
                    //coordenadaAnterior = coordenadaActual;
                    casilleros.add(this.getCasillero(coordenadaActual));    //almacenamos los casilleros
                    coordenadaActual = this.getFilaSiguiente(coordenadaActual);
                }
                return new Palabra(casilleros, Orientacion.VERTICAL);
            }
            case HORIZONTAL -> {
                while (Coordenada.coordenadaExiste(coordenadaActual) && casilleroOcupado(coordenadaActual)) {   //verificamos que la instancia de la coordenada exista
                    coordenadaAnterior = coordenadaActual;
                    coordenadaActual = this.getColumnaAnterior(coordenadaActual);
                }
                coordenadaActual = coordenadaAnterior;
                while (Coordenada.coordenadaExiste(coordenadaActual) && casilleroOcupado(coordenadaActual)) {   //baja hasta la ultima ficha
                    //coordenadaAnterior = coordenadaActual;
                    casilleros.add(this.getCasillero(coordenadaActual));    //almacenamos los casilleros
                    coordenadaActual = this.getColumnaSiguiente(coordenadaActual);
                }
                return new Palabra(casilleros, Orientacion.HORIZONTAL);
            }
            default -> {
                return null;
            }
        }
    }

    public boolean casilleroOcupado(ICoordenada coordenada){
        return casilleros[coordenada.getValorFila()][coordenada.getValorColumna()].estaOcupado();
    }

    public Coordenada getFilaAnterior(ICoordenada coordenada){
        Coordenada nuevaCoordenada = null;
        try{
            nuevaCoordenada = new Coordenada(coordenada.getValorFila()-1,coordenada.getValorColumna());
        }
        catch (CoordenadaInvalida _){
        }
        return nuevaCoordenada;
    }

    public Coordenada getFilaSiguiente(ICoordenada coordenada){
        Coordenada nuevaCoordenada = null;
        try{
            nuevaCoordenada = new Coordenada(coordenada.getValorFila()+1,coordenada.getValorColumna());
        }
        catch (CoordenadaInvalida _){
        }
        return nuevaCoordenada;
    }

    public Coordenada getColumnaAnterior(ICoordenada coordenada){
        Coordenada nuevaCoordenada = null;
        try{
            nuevaCoordenada = new Coordenada(coordenada.getValorFila(),coordenada.getValorColumna()-1);
        }
        catch (CoordenadaInvalida _){
        }
        return nuevaCoordenada;
    }

    public Coordenada getColumnaSiguiente(ICoordenada coordenada){
        Coordenada nuevaCoordenada = null;
        try{
            nuevaCoordenada = new Coordenada(coordenada.getValorFila(),coordenada.getValorColumna()+1);
        }
        catch (CoordenadaInvalida _){
        }
        return nuevaCoordenada;
    }

    public TipoCasillero getTipoCasillero(ICoordenada coordenada){
        return casilleros[coordenada.getValorFila()][coordenada.getValorColumna()].getTipo();
    }



    public Palabra palabraFormada(List<ICasillero> posibleJugada, Orientacion orientacion){
        for(ICasillero casillero : posibleJugada){
            if(this.casilleroOcupado(casillero.getPosicion())){
                throw new CasilleroOcupado("No es posible usar un casillero ocupado");
            }
        }

        ICoordenada coordenada = posibleJugada.getFirst().getPosicion();
        LineaTablero copiaLinea = new LineaTablero(coordenada, orientacion);

        for(ICasillero casillero : posibleJugada){
            copiaLinea.asignarFicha(casillero,orientacion);
        }

        List<ICasillero> copiaCasilleros = copiaLinea.getCasillerosPalabra(coordenada,orientacion);

        for (ICasillero casillero : posibleJugada){
            if(!copiaCasilleros.contains(casillero)){
                throw new JugadaInvalida("La jugada no es posible de realizarse, porque la palabra formada no contiene todas las fichas");
            }
        }

        Palabra palabra;
        try {
            palabra = new Palabra(copiaCasilleros, orientacion);
        } catch (PalabraNoAlineada e) {
            throw new JugadaInvalida(e.getMessage());
        }
        return palabra;
    }
}
