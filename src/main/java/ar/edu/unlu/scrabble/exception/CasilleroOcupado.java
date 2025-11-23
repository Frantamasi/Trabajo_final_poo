package ar.edu.unlu.scrabble.exception;

public class CasilleroOcupado extends RuntimeException {
    public CasilleroOcupado(String message) {
        super(message);
    }
}
