package ar.edu.unlu.scrabble.Interfaces;

import ar.edu.unlu.scrabble.modelo.TipoCasillero;

public interface ITableroPublico {
    public ICasillero getCasillero(ICoordenada coordenada);
    public TipoCasillero getTipoCasillero(ICoordenada coordenada);

}
