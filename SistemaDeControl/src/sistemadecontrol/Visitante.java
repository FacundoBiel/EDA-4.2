package sistemadecontrol;

public class Visitante {
     private String id;

    public Visitante(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitante visitante = (Visitante) o;
        return id.equals(visitante.id);
    }
}
