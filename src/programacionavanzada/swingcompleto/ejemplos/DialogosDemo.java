package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class DialogosDemo extends JFrame {

    public DialogosDemo() {
        super("12 - Cuadros de diálogo predefinidos");
        AppStyles.configurarVentana(this, 560, 300);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("JOptionPane"), BorderLayout.NORTH);

        JPanel botones = new JPanel(new GridLayout(0, 1, 8, 8));
        JButton mensaje = AppStyles.botonPrimario("showMessageDialog");
        JButton entrada = AppStyles.botonPrimario("showInputDialog");
        JButton confirmar = AppStyles.botonPrimario("showConfirmDialog");

        mensaje.addActionListener(e -> JOptionPane.showMessageDialog(this, "Este es un mensaje informativo.", "Mensaje", JOptionPane.INFORMATION_MESSAGE));
        entrada.addActionListener(e -> pedirNombre());
        confirmar.addActionListener(e -> confirmarSalida());

        botones.add(mensaje);
        botones.add(entrada);
        botones.add(confirmar);
        root.add(botones, BorderLayout.CENTER);
        setContentPane(root);
    }

    private void pedirNombre() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese su nombre:", "Victor");
        if (nombre != null && !nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hola " + nombre.trim() + ", el dato fue recibido.");
        }
    }

    private void confirmarSalida() {
        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Desea cerrar esta ventana de demostración?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new DialogosDemo().setVisible(true);
        });
    }
}
