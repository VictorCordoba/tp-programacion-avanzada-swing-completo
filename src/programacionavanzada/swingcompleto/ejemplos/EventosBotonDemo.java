package programacionavanzada.swingcompleto.ejemplos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.util.AppStyles;

public class EventosBotonDemo extends JFrame {
    private int contador = 0;
    private final JLabel estado = new JLabel("Todavía no se pulsó el botón.");

    public EventosBotonDemo() {
        super("08 - Manejo de eventos: JButton");
        AppStyles.configurarVentana(this, 520, 260);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("ActionListener aplicado a un botón"), BorderLayout.NORTH);

        JPanel centro = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 24));
        centro.setBackground(java.awt.Color.WHITE);
        JButton boton = AppStyles.botonPrimario("¡Púlsame!");
        boton.addActionListener(new EventoBotonPulsado());
        centro.add(boton);
        centro.add(estado);
        root.add(centro, BorderLayout.CENTER);
        setContentPane(root);
    }

    private class EventoBotonPulsado implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            contador++;
            JButton boton = (JButton) e.getSource();
            boton.setText("Pulsado " + contador + " veces");
            estado.setText("Evento recibido desde: " + boton.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new EventosBotonDemo().setVisible(true);
        });
    }
}
