package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import programacionavanzada.swingcompleto.util.AppStyles;

public class EventosTextoDocumentDemo extends JFrame {
    private final JTextField texto = new JTextField();
    private final JLabel contador = new JLabel("Caracteres: 0");
    private final JLabel validacion = new JLabel("Estado: pendiente");

    public EventosTextoDocumentDemo() {
        super("10 - Eventos en JTextField");
        AppStyles.configurarVentana(this, 600, 270);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("DocumentListener: validación en tiempo real"), BorderLayout.NORTH);

        JPanel panel = AppStyles.panelConTitulo("Nombre de usuario");
        JPanel campos = new JPanel(new GridLayout(0, 1, 6, 6));
        campos.setOpaque(false);
        campos.add(new JLabel("Ingrese un usuario sin espacios, entre 4 y 12 caracteres:"));
        campos.add(texto);
        campos.add(contador);
        campos.add(validacion);
        panel.add(campos, BorderLayout.CENTER);
        root.add(panel, BorderLayout.CENTER);
        setContentPane(root);

        texto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizar();
            }
        });
    }

    private void actualizar() {
        String valor = texto.getText();
        contador.setText("Caracteres: " + valor.length());
        if (valor.matches("[A-Za-z0-9_]{4,12}")) {
            validacion.setText("Estado: válido");
        } else {
            validacion.setText("Estado: inválido. Usar letras, números o guion bajo, sin espacios.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new EventosTextoDocumentDemo().setVisible(true);
        });
    }
}
