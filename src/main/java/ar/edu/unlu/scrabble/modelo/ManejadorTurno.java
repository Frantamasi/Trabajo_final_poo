package ar.edu.unlu.scrabble.modelo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class ManejadorTurno {
    private Queue<Jugador> jugadores = new LinkedList<>();
    private int turnosPasadosConsecutivos; //encargada de finalizar la partida si se pasa 3 veces seguidas
    private Jugador ultimoJugador;

        public ManejadorTurno(List<Jugador> listaJugadores) {
            jugadores.addAll(listaJugadores);
            turnosPasadosConsecutivos = 0;
        }

        /**
         * al pasar el turno se suma el contador
         *
         * @return true si este llega a 3, se finaliza la partida
         */
        public boolean juegoTermino() {
             return (turnosPasadosConsecutivos == 3) ||
                    (ultimoJugador.atrilEsVacio() && FichasTotales.getInstance().esVacia());
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

    }
