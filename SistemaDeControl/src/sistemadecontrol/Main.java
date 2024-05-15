package sistemadecontrol;

public class Main {

    public static void main(String[] args) {
        SistemaDeControl parque = new SistemaDeControl(5);
        parque.agregarAtraccion("Montaña Rusa");
        parque.agregarAtraccion("Rueda de la Fortuna");

        Visitante v1 = new Visitante("V1");
        Visitante v2 = new Visitante("V2");
        Visitante v3 = new Visitante("V3");

        parque.registrarEntrada(v1);
        parque.registrarEntrada(v2);
        parque.registrarEntrada(v3);

        parque.unirseColaAtraccion(v1, "Montaña Rusa");
        parque.unirseColaAtraccion(v2, "Rueda de la Fortuna");

        parque.mostrarEstado();

        parque.consultarVisitante("V1");

        parque.registrarSalida(v1);
        parque.mostrarEstado();
    }
}
