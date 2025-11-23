package ar.edu.unlu.scrabble.modelo;

import ar.edu.unlu.scrabble.exception.MaximaCantidadJugadores;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ManejadorTurno {
    private Queue<Jugador> jugadores = new LinkedList<>();
    private int turnosPasadosConsecutivos; //encargada de finalizar la partida si se pasa 3 veces seguidas
    private Jugador ultimoJugador;
    private final int JUGADORES_MAX = 4;
        public ManejadorTurno() {
            turnosPasadosConsecutivos = 0;
        }

        /**
         * al pasar el turno se suma el contador
         *
         * @return true si este llega a 3, se finaliza la partida
         */
        public boolean juegoTermino() {
             return (turnosPasadosConsecutivos == 3) ||
                    (ultimoJugador.atrilEsVacio() && BolsaDeFichas.getInstance().esVacia());
        }

        /**
         * pasa el turno
         *
         */
        private void siguienteTurno() {
            Jugador jugadorActual = jugadores.poll();  //lo saca de la cola
            ultimoJugador = jugadorActual;
            jugadores.offer(jugadorActual);    //lo vuelve a agregar
        }
        public void jugarTurno(){
            turnosPasadosConsecutivos = 0;
            siguienteTurno();
        }

        public void pasarTurno(){
            turnosPasadosConsecutivos += 1;
            siguienteTurno();
        }
        /**
         *
         * @return quien es el jugador que juega el turno
         */
        public Jugador getJugadorTurno() {
            return jugadores.peek();
        }

        public void addJugador(Jugador jugador){
            if(jugadores.size() >= JUGADORES_MAX){
                throw new MaximaCantidadJugadores("Se ha alcanzado la maxima cantidad de jugadores");
            }
            jugadores.add(jugador);
        }

        public List<Jugador> getTodosLosJugadores(){
            return jugadores.stream().toList();
        }
    }
