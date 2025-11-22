package ar.edu.unlu.scrabble.modelo;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class ManejadorTurno {
    private Queue<Jugador> jugadores = new Queue<Jugador>() {
    private int turnosPasadosConsecutivos; //encargada de finalizar la partida si se pasa 3 veces seguidas



    public ManejadorTurno(List listaJugadores){
        jugadores.addAll((Collection<? extends Jugador>) listaJugadores);
        turnosPasadosConsecutivos = 0;
    }

        /**
         * al pasar el turno se suma el contador
         * @return  true si este llega a 3, se finaliza la partida
         */
    public boolean pasarTurno(){
        turnosPasadosConsecutivos += 1;
        return turnosPasadosConsecutivos == 3;
    }

        /**
         * pasa el turno
         * @param paso si es false, reinicia el contador de turnos consecutivos pasados
         */
    public void siguienteTurno(boolean paso){
        Jugador siguienteJugador = jugadores.remove();  //lo saca de la cola
        jugadores.add(siguienteJugador);    //lo vuelve a agregar
        if(!paso) turnosPasadosConsecutivos = 0;
    }

        /**
         *
         * @return quien es el jugador que juega el turno
         */
    public Jugador getJugadorTurno(){
        return jugadores.peek();
    }


        @Override
        public boolean add(Jugador jugador) {
            return false;
        }

        @Override
        public boolean offer(Jugador jugador) {
            return false;
        }

        @Override
        public Jugador remove() {
            return null;
        }

        @Override
        public Jugador poll() {
            return null;
        }

        @Override
        public Jugador element() {
            return null;
        }

        @Override
        public Jugador peek() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Jugador> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Jugador> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    }
}
