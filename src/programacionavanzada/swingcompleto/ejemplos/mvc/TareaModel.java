package programacionavanzada.swingcompleto.ejemplos.mvc;

import javax.swing.DefaultListModel;

public class TareaModel {
    private final DefaultListModel<Tarea> tareas = new DefaultListModel<>();

    public DefaultListModel<Tarea> getTareas() {
        return tareas;
    }

    public void agregar(String descripcion) {
        tareas.addElement(new Tarea(descripcion));
    }

    public void marcarCompletada(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            tarea.setCompletada(true);
            tareas.set(indice, tarea);
        }
    }

    public void eliminar(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
        }
    }
}
