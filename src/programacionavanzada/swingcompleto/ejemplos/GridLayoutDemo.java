package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class GridLayoutDemo extends JFrame {
    private final JTextField visor = new JTextField();

    public GridLayoutDemo() {
        super("04 - GridLayout");
        AppStyles.configurarVentana(this, 360, 480);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(8, 8));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("Teclado con GridLayout"), BorderLayout.NORTH);

        visor.setEditable(false);
        visor.setHorizontalAlignment(SwingConstants.RIGHT);
        visor.setFont(new Font("SansSerif", Font.BOLD, 24));
        root.add(visor, BorderLayout.CENTER);

        JPanel teclado = new JPanel(new GridLayout(4, 3, 6, 6));
        String[] botones = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
        for (String texto : botones) {
            JButton boton = AppStyles.botonPrimario(texto);
            boton.addActionListener(e -> visor.setText(visor.getText() + ((JButton) e.getSource()).getText()));
            teclado.add(boton);
        }
        root.add(teclado, BorderLayout.SOUTH);
        setContentPane(root);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new GridLayoutDemo().setVisible(true);
        });
    }
}
