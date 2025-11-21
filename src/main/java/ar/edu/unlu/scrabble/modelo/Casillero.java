package ar.edu.unlu.scrabble.modelo;

public class Casillero {
    private TipoCasillero tipo;
    private Ficha ficha;

    public Casillero(TipoCasillero tipo){
        this.ficha = null;
        this.tipo = tipo;
    }

    public TipoCasillero getTipo() {
        return tipo;
    }

    public void setTipo(TipoCasillero tipo) {
        this.tipo = tipo;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
}
