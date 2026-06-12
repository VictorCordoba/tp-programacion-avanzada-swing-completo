package programacionavanzada.swingcompleto.ejemplos.mvc;

import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class MVCTareasDemo {
    public static void abrir() {
        new TareaController(new TareaModel(), new TareaView()).iniciar();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            abrir();
        });
    }
}
