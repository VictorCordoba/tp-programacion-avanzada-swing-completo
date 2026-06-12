package programacionavanzada.swingcompleto.ejemplos.mvc;

import javax.swing.JOptionPane;

public class TareaController {
    private final TareaModel model;
    private final TareaView view;

    public TareaController(TareaModel model, TareaView view) {
        this.model = model;
        this.view = view;
        vincular();
    }

    private void vincular() {
        view.getLista().setModel(model.getTareas());
        view.getBotonAgregar().addActionListener(e -> agregarTarea());
        view.getBotonCompletar().addActionListener(e -> model.marcarCompletada(view.getLista().getSelectedIndex()));
        view.getBotonEliminar().addActionListener(e -> model.eliminar(view.getLista().getSelectedIndex()));
    }

    private void agregarTarea() {
        String descripcion = view.getCampoTarea().getText().trim();
        if (descripcion.length() < 3) {
            JOptionPane.showMessageDialog(view, "La tarea debe tener al menos 3 caracteres.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        model.agregar(descripcion);
        view.getCampoTarea().setText("");
        view.getCampoTarea().requestFocus();
    }

    public void iniciar() {
        model.agregar("Revisar ejemplos de JFrame");
        model.agregar("Probar layouts y eventos");
        view.setVisible(true);
    }
}
