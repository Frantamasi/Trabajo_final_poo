package ar.edu.unlu.scrabble.Interfaces;

import ar.edu.unlu.scrabble.modelo.TipoCasillero;

public interface ICasilleroPublico {
    public ICoordenada getPosicion();
    public IFicha getFicha();
    public TipoCasillero getTipo();
    public int getPuntajeCasillero();
    public int getMultiplicadorPalabra();
    public boolean estaOcupado();
}
