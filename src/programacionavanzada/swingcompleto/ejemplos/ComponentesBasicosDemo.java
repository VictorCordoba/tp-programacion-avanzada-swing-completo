package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class ComponentesBasicosDemo extends JFrame {
    private final JTextField nombre = new JTextField(18);
    private final JCheckBox aceptar = new JCheckBox("Acepto recibir novedades");
    private final JRadioButton alumno = new JRadioButton("Alumno", true);
    private final JRadioButton profesor = new JRadioButton("Profesor");

    public ComponentesBasicosDemo() {
        super("02 - Componentes básicos");
        AppStyles.configurarVentana(this, 560, 320);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(12, 12));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("JLabel, JTextField, JButton, JCheckBox y JRadioButton"), BorderLayout.NORTH);

        JPanel formulario = AppStyles.panelConTitulo("Datos de prueba");
        JPanel campos = new JPanel(new GridLayout(0, 2, 8, 8));
        campos.setOpaque(false);
        campos.add(new JLabel("Nombre:"));
        campos.add(nombre);
        campos.add(new JLabel("Tipo:"));

        JPanel radios = new JPanel();
        radios.setOpaque(false);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(alumno);
        grupo.add(profesor);
        radios.add(alumno);
        radios.add(profesor);
        campos.add(radios);
        campos.add(new JLabel("Preferencia:"));
        campos.add(aceptar);
        formulario.add(campos, BorderLayout.CENTER);

        JButton mostrar = AppStyles.botonPrimario("Mostrar selección");
        mostrar.addActionListener(e -> mostrarResumen());
        root.add(formulario, BorderLayout.CENTER);
        root.add(mostrar, BorderLayout.SOUTH);
        setContentPane(root);
    }

    private void mostrarResumen() {
        String tipo = alumno.isSelected() ? "Alumno" : "Profesor";
        String novedades = aceptar.isSelected() ? "Sí" : "No";
        String valorNombre = nombre.getText().trim().isEmpty() ? "Sin nombre" : nombre.getText().trim();
        JOptionPane.showMessageDialog(this,
                "Nombre: " + valorNombre + "\nTipo: " + tipo + "\nRecibe novedades: " + novedades,
                "Resumen de componentes",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new ComponentesBasicosDemo().setVisible(true);
        });
    }
}
