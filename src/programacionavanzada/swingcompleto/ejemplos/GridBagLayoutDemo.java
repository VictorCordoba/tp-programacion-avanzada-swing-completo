package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class GridBagLayoutDemo extends JFrame {
    private final JTextField asunto = new JTextField();
    private final JComboBox<String> prioridad = new JComboBox<>(new String[]{"Baja", "Media", "Alta"});
    private final JTextArea descripcion = new JTextArea(5, 30);

    public GridBagLayoutDemo() {
        super("07 - GridBagLayout");
        AppStyles.configurarVentana(this, 620, 420);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("GridBagLayout: formulario flexible"), BorderLayout.NORTH);

        JPanel form = AppStyles.panelConTitulo("Registro de incidencia");
        JPanel campos = new JPanel(new GridBagLayout());
        campos.setOpaque(false);

        campos.add(new JLabel("Asunto:"), AppStyles.gbc(0, 0, 1, 1, 0, 0));
        campos.add(asunto, AppStyles.gbc(1, 0, 2, 1, 1, 0));
        campos.add(new JLabel("Prioridad:"), AppStyles.gbc(0, 1, 1, 1, 0, 0));
        campos.add(prioridad, AppStyles.gbc(1, 1, 1, 1, 1, 0));
        campos.add(new JLabel("Descripción:"), AppStyles.gbc(0, 2, 1, 1, 0, 0));
        GridBagConstraints areaGbc = AppStyles.gbc(1, 2, 2, 2, 1, 1);
        areaGbc.fill = GridBagConstraints.BOTH;
        campos.add(descripcion, areaGbc);

        form.add(campos, BorderLayout.CENTER);

        JButton enviar = AppStyles.botonPrimario("Enviar incidencia");
        enviar.addActionListener(e -> enviar());
        root.add(form, BorderLayout.CENTER);
        root.add(enviar, BorderLayout.SOUTH);
        setContentPane(root);
    }

    private void enviar() {
        if (asunto.getText().trim().length() < 4) {
            JOptionPane.showMessageDialog(this, "El asunto debe tener al menos 4 caracteres.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this,
                "Incidencia registrada\nPrioridad: " + prioridad.getSelectedItem(),
                "GridBagLayout",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new GridBagLayoutDemo().setVisible(true);
        });
    }
}
