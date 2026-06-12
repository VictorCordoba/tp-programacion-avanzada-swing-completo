package programacionavanzada.swingcompleto.ejemplos.mvc;

public class Tarea {
    private final String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return (completada ? "[OK] " : "[ ] ") + descripcion;
    }
}
