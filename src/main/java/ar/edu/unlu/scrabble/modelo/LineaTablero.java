package ar.edu.unlu.scrabble.modelo;

import ar.edu.unlu.scrabble.Interfaces.ICasillero;
import ar.edu.unlu.scrabble.Interfaces.ICoordenada;

import java.util.ArrayList;
import java.util.List;

public class LineaTablero {
    private ICasillero[] linea = new Casillero[15];



    public LineaTablero(ICoordenada coordenada, Orientacion orientacion){

        Coordenada coordenadaActual = null;
        Tablero tablero = Tablero.getInstance();

        switch (orientacion){
            case VERTICAL -> {
                coordenadaActual = new Coordenada(0, coordenada.getValorColumna());
                while((Coordenada.coordenadaExiste(coordenadaActual))){

                    Casillero copiaCasillero = new Casillero(tablero.getTipoCasillero(coordenadaActual),coordenadaActual);
                    copiaCasillero.setFicha(tablero.getCasillero(coordenadaActual).getFicha());

                    linea[coordenadaActual.getValorFila()] = copiaCasillero;
                    coordenadaActual = tablero.getFilaSiguiente(coordenadaActual);

                }
            }
            case HORIZONTAL -> {
                coordenadaActual = new Coordenada(coordenada.getValorFila(), 0);
                while((Coordenada.coordenadaExiste(coordenadaActual))){

                    Casillero copiaCasillero = new Casillero(tablero.getTipoCasillero(coordenadaActual),coordenadaActual);
                    copiaCasillero.setFicha(tablero.getCasillero(coordenadaActual).getFicha());

                    linea[coordenadaActual.getValorColumna()] = copiaCasillero;
                    coordenadaActual = tablero.getColumnaSiguiente(coordenadaActual);

                }
            }
        }
    }

    public void asignarFicha(ICasillero casillero, Orientacion orientacion){
        switch (orientacion){
            case VERTICAL -> {
                linea[casillero.getPosicion().getValorFila()] = casillero;
            }
            case HORIZONTAL -> {
                linea[casillero.getPosicion().getValorColumna()] = casillero;
            }
        }
    }

    public List<ICasillero> getCasillerosPalabra(ICoordenada coordenada, Orientacion orientacion){
        ICoordenada coordenadaActual = coordenada;
        Tablero tablero = Tablero.getInstance();
        List<ICasillero> casilleros = new ArrayList<>();

        switch (orientacion){
            case VERTICAL -> {
                while(Coordenada.coordenadaExiste(coordenadaActual) && linea[coordenadaActual.getValorFila()].estaOcupado()){
                    coordenadaActual = tablero.getFilaAnterior(coordenadaActual);
                }
                while(Coordenada.coordenadaExiste(coordenadaActual) && linea[coordenadaActual.getValorFila()].estaOcupado()){
                    coordenadaActual = tablero.getFilaSiguiente(coordenadaActual);
                    casilleros.add(linea[coordenadaActual.getValorFila()]);
                }
            }
            case HORIZONTAL -> {
                while(Coordenada.coordenadaExiste(coordenadaActual) && linea[coordenadaActual.getValorColumna()].estaOcupado()){
                    coordenadaActual = tablero.getColumnaAnterior(coordenadaActual);
                }
                while(Coordenada.coordenadaExiste(coordenadaActual) && linea[coordenadaActual.getValorColumna()].estaOcupado()){
                    coordenadaActual = tablero.getColumnaSiguiente(coordenadaActual);
                    casilleros.add(linea[coordenadaActual.getValorColumna()]);

                }
            }
        }
        return casilleros;
    }





}
