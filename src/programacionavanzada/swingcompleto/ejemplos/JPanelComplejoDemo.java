package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class JPanelComplejoDemo extends JFrame {
    private final JTextField nombre = new JTextField(16);
    private final JTextField dni = new JTextField(16);
    private final JTextField dia = new JTextField(2);
    private final JTextField mes = new JTextField(2);
    private final JTextField anio = new JTextField(4);

    public JPanelComplejoDemo() {
        super("06 - JPanel compuesto");
        AppStyles.configurarVentana(this, 540, 330);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("Formulario con varios JPanel"), BorderLayout.NORTH);

        JPanel panelFecha = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        panelFecha.setOpaque(false);
        panelFecha.add(dia);
        panelFecha.add(new JLabel("/"));
        panelFecha.add(mes);
        panelFecha.add(new JLabel("/"));
        panelFecha.add(anio);

        JPanel datos = AppStyles.panelConTitulo("Añadir usuario");
        JPanel grillaDatos = new JPanel(new GridLayout(3, 2, 8, 8));
        grillaDatos.setOpaque(false);
        grillaDatos.add(new JLabel("Nombre:"));
        grillaDatos.add(nombre);
        grillaDatos.add(new JLabel("DNI:"));
        grillaDatos.add(dni);
        grillaDatos.add(new JLabel("Fecha de nacimiento:"));
        grillaDatos.add(panelFecha);
        datos.add(grillaDatos, BorderLayout.CENTER);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botones.setOpaque(false);
        JButton aceptar = AppStyles.botonPrimario("Aceptar");
        JButton limpiar = AppStyles.botonPrimario("Limpiar");
        aceptar.addActionListener(e -> validar());
        limpiar.addActionListener(e -> limpiar());
        botones.add(limpiar);
        botones.add(aceptar);

        root.add(datos, BorderLayout.CENTER);
        root.add(botones, BorderLayout.SOUTH);
        setContentPane(root);
    }

    private void validar() {
        if (nombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!dni.getText().trim().matches("\\d{7,8}")) {
            JOptionPane.showMessageDialog(this, "El DNI debe tener 7 u 8 dígitos.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!dia.getText().matches("\\d{1,2}") || !mes.getText().matches("\\d{1,2}") || !anio.getText().matches("\\d{4}")) {
            JOptionPane.showMessageDialog(this, "La fecha debe ingresarse como día / mes / año.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Usuario cargado correctamente.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void limpiar() {
        nombre.setText("");
        dni.setText("");
        dia.setText("");
        mes.setText("");
        anio.setText("");
        nombre.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new JPanelComplejoDemo().setVisible(true);
        });
    }
}
