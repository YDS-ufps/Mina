
/**
 * Write a description of class Juego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Juego {
    private Jugador jugador;
    private Mina mina;
    private Timer temporizador;
    private boolean salir;

    public Juego() {
        jugador = new Jugador();
        mina = new Mina();
        temporizador = new Timer();
        salir = false;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (!salir) {
            System.out.println("Bienvenido a la mina. ¿Qué desea hacer?");
            System.out.println("1. Moverse");
            System.out.println("2. Recolectar carbón");
            System.out.println("3. Buscar salida");
            System.out.println("4. Salir del juego");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    mover();
                    break;
                case 2:
                    jugador.recolectarCarbon();
                    System.out.println("Ha recolectado carbón. Total recolectado: " + jugador.getCantidadDeCarbon());
                    break;
                case 3:
                    buscarSalida();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Gracias por jugar.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
    }

    private void mover() {
        mina.generarEvento();
        if (mina.isBloqueada()) {
            jugador.setEnPeligro(true);
            System.out.println("¡El jugador está en peligro! Debe buscar la salida rápidamente.");
            iniciarTemporizador();
        } else {
            System.out.println("El jugador se ha movido sin problemas.");
        }
    }

    private void buscarSalida() {
        if (jugador.isEnPeligro()) {
            jugador.reducirVida(10);
            jugador.setEnPeligro(false);
            detenerTemporizador();
        } else {
            System.out.println("El jugador ha salido de la mina.");
        }
    }

    private void iniciarTemporizador() {
        temporizador.schedule(new TimerTask() {
            @Override
            public void run() {
                if (jugador.isEnPeligro()) {
                    System.out.println("Tiempo agotado. El jugador debe realizar tareas de refuerzo.");
                    realizarTareasRefuerzo();
                }
            }
        }, 10000); // 10 segundos para encontrar la salida
    }

    private void detenerTemporizador() {
        temporizador.cancel();
        temporizador = new Timer(); // Reiniciar el temporizador
    }

    private void realizarTareasRefuerzo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Debe reforzar su conocimiento de la mina.");
        System.out.println("1. Ver el mapa de la mina");
        System.out.println("2. Reconocer las salidas");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                mostrarMapa();
                break;
            case 2:
                reconocerSalidas();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    private void mostrarMapa() {
        System.out.println("Mostrando el mapa de la mina...");
        // Lógica para mostrar el mapa
    }

    private void reconocerSalidas() {
        System.out.println("Las salidas de la mina son:");
        for (String salida : mina.getSalidas()) {
            System.out.println(salida);
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
    }
}
