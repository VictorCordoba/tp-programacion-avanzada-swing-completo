package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class EventosSaludoReferenciaDemo extends JFrame {

    public EventosSaludoReferenciaDemo() {
        super("09 - Evento con referencia a JTextField");
        AppStyles.configurarVentana(this, 560, 230);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("Acceso a componentes desde el manejador"), BorderLayout.NORTH);

        JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 20));
        fila.setBackground(java.awt.Color.WHITE);
        fila.add(new JLabel("Nombre:"));
        JTextField texto = new JTextField(20);
        fila.add(texto);
        JButton saludar = AppStyles.botonPrimario("Saludar");
        saludar.addActionListener(new EventoSaludo(texto));
        fila.add(saludar);
        root.add(fila, BorderLayout.CENTER);
        setContentPane(root);
    }

    private static class EventoSaludo implements ActionListener {
        private final JTextField cuadroTexto;

        public EventoSaludo(JTextField cuadroTexto) {
            this.cuadroTexto = cuadroTexto;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = cuadroTexto.getText().trim();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo nombre está vacío.", "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "¡Hola, " + nombre + "!", "Saludo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new EventosSaludoReferenciaDemo().setVisible(true);
        });
    }
}
