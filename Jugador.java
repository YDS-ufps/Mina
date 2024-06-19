
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador {
    private int nivelDeVida;
    private int cantidadDeCarbon;
    private boolean enPeligro;

    public Jugador() {
        this.nivelDeVida = 100; // Vida inicial
        this.cantidadDeCarbon = 0; // Carbon inicial
        this.enPeligro = false;
    }

    public int getNivelDeVida() {
        return nivelDeVida;
    }

    public void reducirVida(int cantidad) {
        nivelDeVida -= cantidad;
        if (nivelDeVida <= 0) {
            System.out.println("El jugador ha perdido la vida.");
        }
    }

    public void recolectarCarbon() {
        cantidadDeCarbon++;
    }

    public int getCantidadDeCarbon() {
        return cantidadDeCarbon;
    }

    public void setEnPeligro(boolean enPeligro) {
        this.enPeligro = enPeligro;
    }

    public boolean isEnPeligro() {
        return enPeligro;
    }

    public void reiniciar() {
        nivelDeVida = 100;
        cantidadDeCarbon = 0;
        enPeligro = false;
    }
}
