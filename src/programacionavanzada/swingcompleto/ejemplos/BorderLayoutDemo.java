package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class BorderLayoutDemo extends JFrame {

    public BorderLayoutDemo() {
        super("05 - BorderLayout");
        AppStyles.configurarVentana(this, 650, 420);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(8, 8));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(zona("NORTH - encabezado", AppStyles.AZUL), BorderLayout.NORTH);
        root.add(zona("WEST - menú", new Color(84, 132, 166)), BorderLayout.WEST);
        root.add(zona("CENTER - contenido principal", Color.WHITE), BorderLayout.CENTER);
        root.add(zona("EAST - acciones", new Color(234, 238, 244)), BorderLayout.EAST);
        root.add(zona("SOUTH - pie de ventana", new Color(224, 232, 240)), BorderLayout.SOUTH);
        setContentPane(root);
    }

    private JPanel zona(String texto, Color fondo) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(fondo);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(AppStyles.GRIS_BORDE),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setFont(AppStyles.SUBTITULO);
        if (fondo.equals(AppStyles.AZUL) || fondo.equals(new Color(84, 132, 166))) {
            label.setForeground(Color.WHITE);
        }
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new BorderLayoutDemo().setVisible(true);
        });
    }
}
