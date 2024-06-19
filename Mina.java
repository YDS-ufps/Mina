
/**
 * Write a description of class Mina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;

public class Mina {
    private String[] salidas = {"Salida 1", "Salida 2", "Salida 3"};
    private boolean bloqueada;

    public Mina() {
        this.bloqueada = false;
    }

    public String[] getSalidas() {
        return salidas;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void generarEvento() {
        Random rand = new Random();
        int evento = rand.nextInt(3); // 0: Nada, 1: Caída de rocas, 2: Gases
        switch (evento) {
            case 1:
                bloqueada = true;
                System.out.println("Evento de riesgo: Caída de rocas");
                break;
            case 2:
                bloqueada = true;
                System.out.println("Evento de riesgo: Presencia de gases");
                break;
            default:
                bloqueada = false;
                System.out.println("No hay eventos de riesgo.");
                break;
        }
    }

    public void desbloquear() {
        bloqueada = false;
    }
}
