package sistemadecontrol;

import java.util.LinkedList;
import java.util.Queue;

public class SistemaDeControl {
     private final int capacidadMaxima;
    private Queue<Visitante> colaEntrada;
    private Queue<Visitante> dentroDelParque;
    private LinkedList<ColaAtraccion> colasAtracciones;

    public SistemaDeControl(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.colaEntrada = new LinkedList<>();
        this.dentroDelParque = new LinkedList<>();
        this.colasAtracciones = new LinkedList<>();
    }

    public void registrarEntrada(Visitante visitante) {
        if (dentroDelParque.size() < capacidadMaxima) {
            colaEntrada.offer(visitante);
            dentroDelParque.offer(visitante);
            System.out.println("El visitante " + visitante.getId() + " ha entrado al parque.");
        } else {
            System.out.println("El parque está a plena capacidad. Por favor espere.");
        }
    }

    public void registrarSalida(Visitante visitante) {
        if (dentroDelParque.contains(visitante)) {
            dentroDelParque.remove(visitante);
            colaEntrada.remove(visitante);
            System.out.println("El visitante " + visitante.getId() + " ha salido del parque.");
        } else {
            System.out.println("Visitante no encontrado en el parque.");
        }
    }

    public void agregarAtraccion(String nombreAtraccion) {
        colasAtracciones.add(new ColaAtraccion(nombreAtraccion));
    }

    public void unirseColaAtraccion(Visitante visitante, String nombreAtraccion) {
        for (ColaAtraccion cola : colasAtracciones) {
            if (cola.getNombre().equals(nombreAtraccion)) {
                cola.agregarVisitante(visitante);
                return;
            }
        }
        System.out.println("Atracción no encontrada.");
    }

    public void salirColaAtraccion(Visitante visitante, String nombreAtraccion) {
        for (ColaAtraccion cola : colasAtracciones) {
            if (cola.getNombre().equals(nombreAtraccion)) {
                cola.eliminarVisitante(visitante);
                return;
            }
        }
        System.out.println("Atracción no encontrada.");
    }

    public void consultarVisitante(String idVisitante) {
        for (Visitante v : dentroDelParque) {
            if (v.getId().equals(idVisitante)) {
                System.out.println("El visitante " + idVisitante + " está en el parque.");
                return;
            }
        }
        System.out.println("El visitante " + idVisitante + " no está en el parque.");
    }

    public void mostrarEstado() {
        System.out.println("Ocupación actual del parque: " + dentroDelParque.size() + "/" + capacidadMaxima);
        for (ColaAtraccion cola : colasAtracciones) {
            System.out.println("Cola de " + cola.getNombre() + ": " + cola.getTamaño() + " personas.");
        }
    }
}
