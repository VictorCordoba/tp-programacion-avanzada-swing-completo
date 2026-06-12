package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class DibujoSolDemo extends JFrame {

    public DibujoSolDemo() {
        super("13 - Dibujo de gráficos");
        AppStyles.configurarVentana(this, 560, 520);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(8, 8));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("paintComponent: dibujo personalizado"), BorderLayout.NORTH);
        root.add(new PanelSolMejorado(), BorderLayout.CENTER);
        setContentPane(root);
    }

    public static class PanelSolMejorado extends JPanel {
        public PanelSolMejorado() {
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int centroX = getWidth() / 2;
            int centroY = getHeight() / 2;
            int radio = Math.min(getWidth(), getHeight()) / 5;

            g2.setColor(new Color(255, 201, 76));
            g2.setStroke(new BasicStroke(3f));
            for (double d = 0; d < 2 * Math.PI; d += 0.22) {
                int xInicio = (int) (centroX + (radio + 10) * Math.cos(d));
                int yInicio = (int) (centroY + (radio + 10) * Math.sin(d));
                int xFin = (int) (centroX + (radio + 60) * Math.cos(d));
                int yFin = (int) (centroY + (radio + 60) * Math.sin(d));
                g2.drawLine(xInicio, yInicio, xFin, yFin);
            }

            g2.setColor(new Color(255, 178, 46));
            g2.fillOval(centroX - radio, centroY - radio, radio * 2, radio * 2);
            g2.setColor(Color.BLACK);
            g2.fillOval(centroX - radio / 2, centroY - radio / 4, 18, 18);
            g2.fillOval(centroX + radio / 2 - 18, centroY - radio / 4, 18, 18);
            g2.drawArc(centroX - radio / 2, centroY - 8, radio, radio / 2, 200, 140);

            g2.setFont(new Font("SansSerif", Font.BOLD, 16));
            g2.setColor(new Color(60, 60, 60));
            g2.drawString("Dibujo realizado sobrescribiendo paintComponent(Graphics g)", 24, getHeight() - 24);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new DibujoSolDemo().setVisible(true);
        });
    }
}
