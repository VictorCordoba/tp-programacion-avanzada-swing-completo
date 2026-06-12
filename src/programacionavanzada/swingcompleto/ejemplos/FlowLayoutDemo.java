package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class FlowLayoutDemo extends JFrame {
    private final JTextField texto = new JTextField(22);

    public FlowLayoutDemo() {
        super("03 - FlowLayout");
        AppStyles.configurarVentana(this, 580, 230);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("FlowLayout: componentes uno al lado del otro"), BorderLayout.NORTH);

        JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 12));
        fila.setBackground(java.awt.Color.WHITE);
        fila.add(new JLabel("Nombre:"));
        fila.add(texto);
        JButton saludar = AppStyles.botonPrimario("Saludar");
        saludar.addActionListener(e -> saludar());
        fila.add(saludar);

        root.add(fila, BorderLayout.CENTER);
        setContentPane(root);
    }

    private void saludar() {
        String nombre = texto.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresá un nombre para poder saludar.", "Validación", JOptionPane.WARNING_MESSAGE);
            texto.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "¡Hola, " + nombre + "!", "Saludo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new FlowLayoutDemo().setVisible(true);
        });
    }
}
