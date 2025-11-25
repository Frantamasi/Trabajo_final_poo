package ar.edu.unlu.scrabble.vista;

import ar.edu.unlu.scrabble.Interfaces.ICasillero;
import ar.edu.unlu.scrabble.Interfaces.IFicha;
import ar.edu.unlu.scrabble.exception.CoordenadaInvalida;
import ar.edu.unlu.scrabble.modelo.*;

import java.util.*;

public class VistaConsola {
    private Scanner sc = new Scanner(System.in);


    public int obtenerOpcionInt(){
        return sc.nextInt();
    }

    public String obtenerOpcionString(String mensaje){
        System.out.println(mensaje);
        String opcion;
        while (true){
            opcion = sc.nextLine();
            if(!opcion.isEmpty()){
                break;
            }
        }
        return opcion;
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public  void mostrarMenu(){
        System.out.println("\n========================================");
        System.out.println("      S C R A B B L E   J A V A");
        System.out.println("========================================");
        System.out.println("  1. Iniciar Nueva Partida");
        System.out.println("  2. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Muestra el tablero en consola con alineación perfecta.
     * Muestra coordenadas y códigos de texto para los premios.
     */
    public void mostrarTablero() {
        System.out.println("\n");
        Tablero tablero = Tablero.getInstance();
        System.out.print("    "); // Espacio inicial para la columna de números de fila
        for (int i = 0; i < 15; i++) {
            System.out.printf("%-4d", i);
        }
        System.out.println();

        System.out.print("    ");
        for (int i = 0; i < 15; i++) System.out.print("----");
        System.out.println();

        for (int i = 0; i < 15; i++) {
            System.out.printf("%2d |", i);
            for (int j = 0; j < 15; j++) {
                ICasillero casillero = tablero.getCasillero(new Coordenada(i,j));
                String texto = obtenerTextoCasillero(casillero);
                System.out.printf("%-4s", texto);
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    /**
     * Método auxiliar que decide qué texto mostrar en cada cuadradito.
     * @param casillero El casillero a evaluar.
     * @return Un String corto (ej: "[A]", "3P", "..")
     */
    private String obtenerTextoCasillero(ICasillero casillero) {
        if (casillero.estaOcupado()) {
            // Mostramos la letra entre corchetes. Ej: [A]
            return "[" + casillero.getFicha().getLetra() + "]";
        }
        else {
            switch (casillero.getTipo()) {
                case PUNTAJE_TRIPLE_PALABRA:
                    return "3P"; // Triple Palabra
                case PUNTAJE_DOBLE_PALABRA:
                    return "2P"; // Doble Palabra
                case PUNTAJE_TRIPLE_LETRA:
                    return "3L"; // Triple Letra
                case PUNTAJE_DOBLE_LETRA:
                    return "2L"; // Doble Letra
                case PUNTAJE_NORMAL:
                default:
                    return ".."; // Casilla normal (puntos)
            }
        }
    }

    /**
     * Muestra las fichas del jugador en formato horizontal.
     * Ejemplo visual: [ A | 1 ]  [ B | 3 ]  [ Z | 10 ]
     * @param atril Lista de fichas del jugador
     */
    public void mostrarAtril(List<IFicha> atril) {
        System.out.println("\n > TUS FICHAS:");
        System.out.print("   "); // Margen izquierdo
        if (atril.isEmpty()) {
            System.out.println("(Atril vacío)");
            return;
        }
        for (IFicha ficha : atril) {
            String letra = String.valueOf(ficha.getLetra()); // Convertimos a String por seguridad
            int puntos = ficha.getPuntaje();
            System.out.printf("[ %s : %-2d ]  ", letra, puntos);
        }
        System.out.println("\n");
    }
    /**
     * Muestra el encabezado con el nombre y puntaje del jugador actual.
     * Diseño tipo "Marcador".
     * @param jugador El objeto jugador con métodos .getNombre() y .getPuntaje()
     */
    public void mostrarInfoJugador(Jugador jugador) {
        String nombre = jugador.getNombre().toUpperCase(); // Convertimos a mayúsculas para estandarizar
        int puntaje = jugador.getPuntaje();

        System.out.println("========================================");
        System.out.printf(" JUGADOR: %-15s |  PUNTOS: %d\n", nombre, puntaje);
        System.out.println("========================================");
    }
    /**
     * Muestra el podio final ordenado por puntaje de mayor a menor.
     * @param jugadores Lista original de jugadores.
     */
    public void mostrarRankingFinal(List<Jugador> jugadores) {
        List<Jugador> ranking = new ArrayList<>(jugadores);
        ranking.sort((j1, j2) -> Integer.compare(j2.getPuntaje(), j1.getPuntaje()));

        System.out.println("\n\n");
        System.out.println("******************************************");
        System.out.println("           PARTIDA FINALIZADA             ");
        System.out.println("******************************************");
        System.out.println("\n   RANKING FINAL:");
        System.out.println("   ---------------------------------------");

        for (int i = 0; i < ranking.size(); i++) {
            Jugador j = ranking.get(i);
            System.out.printf("   %d. %-15s | %4d pts\n",
                    (i + 1),
                    j.getNombre().toUpperCase(),
                    j.getPuntaje());
        }
        System.out.println("   ---------------------------------------");
        if (!ranking.isEmpty()) {
            System.out.println("\n   ¡FELICITACIONES " + ranking.get(0).getNombre().toUpperCase() + "!");
            System.out.println("          Has ganado la partida.");
        }
        System.out.println("\n******************************************\n");
    }

    /**
     * Muestra un mensaje de despedida con formato y créditos.
     */
    public void mostrarSalida() {
        System.out.println("\n");
        System.out.println("  .==============================================.");
        System.out.println("  |                                              |");
        System.out.println("  |        ¡GRACIAS POR JUGAR SCRABBLE!          |");
        System.out.println("  |                                              |");
        System.out.println("  |----------------------------------------------|");
        System.out.println("  |            Cerrando aplicación...            |");
        System.out.println("  '=============================================='");
        System.out.println("\n");
    }

    /**
     * Ciclo interactivo para registrar usuarios antes de iniciar la partida.
     * Se asegura de cumplir las reglas de mín (2) y máx (4) jugadores.
     */
    public List<String> configurarPartida() {
        System.out.println("\n========================================");
        System.out.println("      REGISTRO DE JUGADORES");
        System.out.println("========================================");
        System.out.println("Nota: Se necesitan entre 2 y 4 jugadores.");
        List<String> nombresJugadores = new ArrayList<>();
        int registrados = 0;
        boolean seguirAgregando = true;

        while (seguirAgregando && registrados < 4) {
            System.out.println("\n-> Datos del jugador " + (registrados + 1));
            String nombre = obtenerOpcionString("El nombre NO puede estar vacio!!!");

            if(nombresJugadores.contains(nombre)){
                System.out.println("Error: ya se encuentra registrado un jugador con el nombre "+nombre);
            }
            else{
               nombresJugadores.add(nombre);
                System.out.println("Jugador " + nombre + " registrado con exito");
                registrados++;

                if (registrados >= 2 && registrados < 4) {
                    seguirAgregando = preguntarSiAgregaOtro();
                } else if (registrados == 4) {
                    System.out.println("\n   Se ha alcanzado el maximo de jugadores");
                }
            }
        }
        System.out.println("\n========================================");
        System.out.println("   Partida configurada! Iniciando...");
        System.out.println("========================================\n");
        return nombresJugadores;
    }

    private boolean preguntarSiAgregaOtro() {
        System.out.print("\n¿Desea agregar otro jugador? (S/N): ");
        String respuesta = sc.next().trim().toUpperCase();
        sc.nextLine(); // Limpiar el buffer del scanner después del next()
        return respuesta.equals("S");
    }
    public Map<Integer, List<Integer>> pedirJugada(Jugador jugador, boolean primerTurno) {
        // 1. CORRECCIÓN: Inicializamos el mapa AFUERA del bucle para no borrar datos previos
        Map<Integer, List<Integer>> jugada = new HashMap<>();
        boolean seguirAgregando = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- ARMAR JUGADA ---");
        if (primerTurno) {
            System.out.println("(!) AVISO: Al ser el primer turno, una ficha debe ocupar el centro (7, 7).");
        }

        mostrarAtrilConIndices(jugador.consultarAtril());

        while (seguirAgregando) {
            System.out.println("\n> Agregando ficha #" + (jugada.size() + 1));

            int indiceAtril = -1;
            // Validación de índice del atril
            while (indiceAtril < 0 || indiceAtril >= jugador.consultarAtril().size() || jugada.containsKey(indiceAtril)) {
                System.out.print("   Ingresa el NÚMERO (índice) de la ficha a usar: ");
                indiceAtril = obtenerOpcionInt();

                if (jugada.containsKey(indiceAtril)) {
                    System.out.println("   ! Ya usaste esa ficha en esta jugada. Elige otra.");
                } else if (indiceAtril < 0 || indiceAtril >= jugador.consultarAtril().size()) {
                    System.out.println("   ! Índice inválido.");
                }
            }

            System.out.print("   Fila destino (0-14): ");
            int fila = obtenerOpcionInt();

            System.out.print("   Columna destino (0-14): ");
            int col = obtenerOpcionInt();

            // Guardamos como lista para mantener compatibilidad con tu retorno
            List<Integer> valoresRaw = new ArrayList<>();
            valoresRaw.add(fila);
            valoresRaw.add(col);

            jugada.put(indiceAtril, valoresRaw);
            System.out.println("   ✓ Ficha agregada temporalmente.");

            // Lógica de continuar o terminar
            if (jugada.size() < jugador.consultarAtril().size()) {
                System.out.print("\n¿Agregar otra letra a esta palabra? (S/N): ");
                String respuesta = scanner.next().toUpperCase();
                scanner.nextLine(); // Limpiar buffer

                if (respuesta.equals("N")) {
                    if (primerTurno) {
                        // AQUÍ LLAMAMOS A LA NUEVA VALIDACIÓN
                        if (validarCentroCubierto(jugada)) {
                            seguirAgregando = false;
                        } else {
                            System.out.println("\n   (!) REGLA: Primer turno. Alguna ficha debe estar en el centro (7, 7).");
                            System.out.println("   Por favor agrega la ficha faltante.");
                        }
                    } else {
                        seguirAgregando = false;
                    }
                }
            } else {
                // Se acabaron las fichas
                if (primerTurno && !validarCentroCubierto(jugada)) {
                    System.out.println("\n   (!) ERROR CRÍTICO: Usaste todas tus fichas y no tocaste el centro.");
                    return new HashMap<>(); // Reiniciar turno
                }
                System.out.println("   ! Has usado todas tus fichas.");
                seguirAgregando = false;
            }
        }

        return jugada;
    }

    /**
     * Valida utilizando la clase Coordenada del modelo.
     */
    private boolean validarCentroCubierto(Map<Integer, List<Integer>> jugada) {
        for (List<Integer> parOrdenado : jugada.values()) {
            try {
                // Instanciamos tu clase Coordenada.
                // Si fila o columna están mal, el constructor lanzará excepción.
                Coordenada coord = new Coordenada(parOrdenado.get(0), parOrdenado.get(1));

                // Usamos tus getters para validar
                if (coord.getValorFila() == 7 && coord.getValorColumna() == 7) {
                    return true;
                }
            } catch (CoordenadaInvalida e) {
                // Este catch atrapa si por error llegaron números fuera de 0-14
                System.out.println("Error interno: " + e.getMessage());
            }
        }
        return false;
    }

    /**
     * Muestra las fichas del jugador con un índice numérico arriba.
     * Útil para cuando el jugador debe elegir una ficha por su posición (0, 1, 2...).
     * * @param atril Lista de fichas del jugador
     */
    public void mostrarAtrilConIndices(List<IFicha> atril) {
        System.out.println("\n > TUS FICHAS:");

        if (atril.isEmpty()) {
            System.out.println("   (Atril vacío)");
            return;
        }

        System.out.print("   "); // Margen izquierdo
        for (int i = 0; i < atril.size(); i++) {    //indices
            System.out.printf("     %d      ", i);
        }
        System.out.println(); // Salto de línea
        System.out.print("   ");
        for (IFicha ficha : atril) {
            String letra = ficha.getLetra();
            int puntos = ficha.getPuntaje();
            System.out.printf("[ %s : %-2d ]  ", letra, puntos);
        }
        System.out.println("\n");
    }

}
