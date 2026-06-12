package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class EventosVentanaMouseTecladoDemo extends JFrame {
    private final JTextArea log = new JTextArea();
    private final JLabel zonaMouse = new JLabel("Mover o hacer clic aquí", SwingConstants.CENTER);

    public EventosVentanaMouseTecladoDemo() {
        super("11 - Eventos de ventana, mouse y teclado");
        AppStyles.configurarVentana(this, 680, 460);
        construirInterfaz();
        registrarEventos();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("WindowListener, MouseListener y KeyListener"), BorderLayout.NORTH);

        zonaMouse.setOpaque(true);
        zonaMouse.setBackground(Color.WHITE);
        zonaMouse.setFont(AppStyles.SUBTITULO);
        root.add(zonaMouse, BorderLayout.CENTER);

        log.setRows(7);
        log.setEditable(false);
        log.setText("Log de eventos:\n");
        root.add(new JScrollPane(log), BorderLayout.SOUTH);
        setContentPane(root);
        setFocusable(true);
    }

    private void registrarEventos() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                agregarLog("Ventana abierta");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                agregarLog("Ventana cerrándose");
            }
        });

        zonaMouse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                agregarLog("Clic de mouse en X=" + e.getX() + " Y=" + e.getY());
                requestFocusInWindow();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                zonaMouse.setText("Mouse dentro del panel");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                zonaMouse.setText("Mouse fuera del panel");
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                agregarLog("Tecla presionada: " + KeyEvent.getKeyText(e.getKeyCode()));
            }
        });
    }

    private void agregarLog(String mensaje) {
        log.append("- " + mensaje + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new EventosVentanaMouseTecladoDemo().setVisible(true);
        });
    }
}
