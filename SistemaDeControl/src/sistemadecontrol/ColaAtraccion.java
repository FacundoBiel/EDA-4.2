package sistemadecontrol;

import java.util.LinkedList;
import java.util.Queue;

public class ColaAtraccion {
    private String nombre;
    private Queue<Visitante> cola;

    public ColaAtraccion(String nombre) {
        this.nombre = nombre;
        this.cola = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarVisitante(Visitante visitante) {
        cola.offer(visitante);
    }

    public void eliminarVisitante(Visitante visitante) {
        cola.remove(visitante);
    }

    public int getTamaño() {
        return cola.size();
    }
}
