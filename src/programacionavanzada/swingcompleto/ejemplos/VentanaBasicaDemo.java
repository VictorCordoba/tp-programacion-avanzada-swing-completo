package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class VentanaBasicaDemo extends JFrame {

    public VentanaBasicaDemo() {
        super("01 - Ventana básica con JFrame");
        AppStyles.configurarVentana(this, 500, 280);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);

        JLabel titulo = AppStyles.titulo("Ventana básica");
        JLabel texto = new JLabel("Ejemplo de JFrame mejorado: título, tamaño, cierre y centrado.");
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setFont(AppStyles.NORMAL);

        root.add(titulo, BorderLayout.NORTH);
        root.add(texto, BorderLayout.CENTER);
        setContentPane(root);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new VentanaBasicaDemo().setVisible(true);
        });
    }
}
