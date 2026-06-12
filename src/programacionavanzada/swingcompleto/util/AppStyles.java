package programacionavanzada.swingcompleto.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class AppStyles {
    public static final Color AZUL = new Color(35, 87, 137);
    public static final Color VERDE = new Color(47, 132, 93);
    public static final Color GRIS_FONDO = new Color(245, 247, 250);
    public static final Color GRIS_BORDE = new Color(220, 225, 232);
    public static final Font TITULO = new Font("SansSerif", Font.BOLD, 20);
    public static final Font SUBTITULO = new Font("SansSerif", Font.BOLD, 15);
    public static final Font NORMAL = new Font("SansSerif", Font.PLAIN, 14);

    private AppStyles() {
    }

    public static void aplicarLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    return;
                }
            }
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.err.println("No se pudo aplicar LookAndFeel. Se utiliza el predeterminado.");
        }
    }

    public static void configurarVentana(JFrame frame, int ancho, int alto) {
        frame.setSize(ancho, alto);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(GRIS_FONDO);
    }

    public static JLabel titulo(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(TITULO);
        label.setForeground(AZUL);
        return label;
    }

    public static JLabel subtitulo(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(SUBTITULO);
        label.setForeground(new Color(60, 60, 60));
        return label;
    }

    public static JButton botonPrimario(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(NORMAL);
        boton.setFocusPainted(false);
        return boton;
    }

    public static JPanel panelConTitulo(String titulo) {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GRIS_BORDE),
                BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));
        panel.add(subtitulo(titulo), BorderLayout.NORTH);
        return panel;
    }

    public static GridBagConstraints gbc(int x, int y, int w, int h, double wx, double wy) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.weightx = wx;
        gbc.weighty = wy;
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        return gbc;
    }

    public static void agregarMargen(JPanel panel) {
        panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
    }
}
