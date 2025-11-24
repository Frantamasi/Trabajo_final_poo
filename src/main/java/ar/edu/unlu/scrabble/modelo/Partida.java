package ar.edu.unlu.scrabble.modelo;

import ar.edu.unlu.scrabble.Interfaces.ICasillero;
import ar.edu.unlu.scrabble.Interfaces.IFicha;
import ar.edu.unlu.scrabble.Interfaces.ITableroPublico;
import ar.edu.unlu.scrabble.observer.Observable;
import ar.edu.unlu.scrabble.observer.Observador;
import ar.edu.unlu.scrabble.exception.JugadaInvalida;
import ar.edu.unlu.scrabble.exception.MaximaCantidadJugadores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partida implements Observable {
    private ManejadorTurno manejadorTurno;
    private List<Observador> observadores;

    public Partida(){
        manejadorTurno = new ManejadorTurno();

    }
    public void jugarPalabra(Map<Integer,List<Integer>> jugada, Orientacion orientacion){

        Tablero tablero = Tablero.getInstance();
        Jugador jugador = manejadorTurno.getJugadorTurno();

        List<ICasillero> casillerosAUtilizar = jugada.entrySet().stream().map((entrada) -> {
            IFicha ficha = jugador.jugar(entrada.getKey().intValue());
            List<Integer> posiciones = entrada.getValue();
            int fila = posiciones.removeFirst().intValue();
            int columna = posiciones.removeFirst().intValue();
            Coordenada coordenada = new Coordenada(fila, columna);
            ICasillero casillero = new Casillero(tablero.getTipoCasillero(coordenada),coordenada);
            casillero.setFicha(ficha);
            return casillero;
        }).toList();

        Palabra palabra = tablero.palabraFormada(casillerosAUtilizar, orientacion);
        FormadorPalabras formadorPalabras = FormadorPalabras.getInstance();

        if(!formadorPalabras.formarPalabras(palabra).validar()){
            throw new JugadaInvalida("Las palabras formadas no se encuentran en el diccionario");
        }

        tablero.setCasilleros(casillerosAUtilizar); //introduce las fichas al tablero
        //TODO: Lanzar evento de atril completado
        jugador.completarAtril(BolsaDeFichas.getInstance());
        int puntaje = formadorPalabras.getPuntaje();
        //TODO: LANZAR EVENTO JUGADOR LANZO TURNO
        jugador.sumarPuntos(puntaje);

        manejadorTurno.jugarTurno();
        if (manejadorTurno.juegoTermino()){
            //TODO: notificar q termino el juego
            notificarObservadores();
        }
    }

    public void pasar(){
        manejadorTurno.pasarTurno();
        if (manejadorTurno.juegoTermino()){
            //TODO: notificar q termino el juego
            notificarObservadores();
        }
    }

    public void agregarJugador(String nombre){
        try{
            Jugador jugador = new Jugador(nombre);
            manejadorTurno.addJugador(jugador);
            ManejadorJugadores.getInstance().addJugador(jugador);
        } catch (RuntimeException e) {
            throw new MaximaCantidadJugadores(e.getMessage());
        }
        notificarObservadores();
    }

    public Map<String,Integer> getResultadoFinal(){
        List<Jugador> listaJugadores = manejadorTurno.getTodosLosJugadores();
        Map<String, Integer> resultados = new HashMap<>();
        listaJugadores.forEach((jugador)->{
            resultados.put(jugador.getNombre(), jugador.getPuntajeFinal());
        });
        return resultados;
    }

    public ITableroPublico verTablero(){
        return Tablero.getInstance();
    }

    public List<IFicha> verAtrilJugador(String nombre){
        return ManejadorJugadores.getInstance().getJugador(nombre).consultarAtril();
    }

    public int verPuntajeJugador(String nombre){
        return  ManejadorJugadores.getInstance().getJugador(nombre).getPuntaje();
    }


    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void quitarObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        observadores.forEach(observador -> {
            observador.actualizar();
        });
    }
}
