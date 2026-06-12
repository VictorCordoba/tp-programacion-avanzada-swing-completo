package programacionavanzada.swingcompleto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import programacionavanzada.swingcompleto.ejemplos.BorderLayoutDemo;
import programacionavanzada.swingcompleto.ejemplos.ComponentesBasicosDemo;
import programacionavanzada.swingcompleto.ejemplos.DialogosDemo;
import programacionavanzada.swingcompleto.ejemplos.DibujoSolDemo;
import programacionavanzada.swingcompleto.ejemplos.EventosBotonDemo;
import programacionavanzada.swingcompleto.ejemplos.EventosSaludoReferenciaDemo;
import programacionavanzada.swingcompleto.ejemplos.EventosTextoDocumentDemo;
import programacionavanzada.swingcompleto.ejemplos.EventosVentanaMouseTecladoDemo;
import programacionavanzada.swingcompleto.ejemplos.FlowLayoutDemo;
import programacionavanzada.swingcompleto.ejemplos.GridBagLayoutDemo;
import programacionavanzada.swingcompleto.ejemplos.GridLayoutDemo;
import programacionavanzada.swingcompleto.ejemplos.JPanelComplejoDemo;
import programacionavanzada.swingcompleto.ejemplos.VentanaBasicaDemo;
import programacionavanzada.swingcompleto.ejemplos.mvc.MVCTareasDemo;
import programacionavanzada.swingcompleto.util.AppStyles;

public class MainMenu extends JFrame {

    public MainMenu() {
        super("Programación Avanzada - Ejemplos Swing Completo");
        AppStyles.configurarVentana(this, 760, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(12, 12));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);

        JLabel titulo = AppStyles.titulo("Trabajo práctico: Swing Completo");
        JLabel bajada = new JLabel("Alumno: Victor Cordoba - Legajo: 114045 - Programación Avanzada");
        bajada.setFont(AppStyles.NORMAL);

        JPanel header = new JPanel(new GridLayout(2, 1, 4, 4));
        header.setOpaque(false);
        header.add(titulo);
        header.add(bajada);
        root.add(header, BorderLayout.NORTH);

        JPanel grilla = new JPanel(new GridLayout(0, 2, 10, 10));
        grilla.setOpaque(false);

        agregarDemo(grilla, "01 - Ventana básica JFrame", () -> new VentanaBasicaDemo().setVisible(true));
        agregarDemo(grilla, "02 - Componentes básicos", () -> new ComponentesBasicosDemo().setVisible(true));
        agregarDemo(grilla, "03 - FlowLayout mejorado", () -> new FlowLayoutDemo().setVisible(true));
        agregarDemo(grilla, "04 - GridLayout / teclado", () -> new GridLayoutDemo().setVisible(true));
        agregarDemo(grilla, "05 - BorderLayout / paneles", () -> new BorderLayoutDemo().setVisible(true));
        agregarDemo(grilla, "06 - JPanel compuesto", () -> new JPanelComplejoDemo().setVisible(true));
        agregarDemo(grilla, "07 - GridBagLayout", () -> new GridBagLayoutDemo().setVisible(true));
        agregarDemo(grilla, "08 - Evento de botón", () -> new EventosBotonDemo().setVisible(true));
        agregarDemo(grilla, "09 - Evento saludo con componente", () -> new EventosSaludoReferenciaDemo().setVisible(true));
        agregarDemo(grilla, "10 - JTextField + DocumentListener", () -> new EventosTextoDocumentDemo().setVisible(true));
        agregarDemo(grilla, "11 - Ventana, mouse y teclado", () -> new EventosVentanaMouseTecladoDemo().setVisible(true));
        agregarDemo(grilla, "12 - JOptionPane", () -> new DialogosDemo().setVisible(true));
        agregarDemo(grilla, "13 - Dibujo con paintComponent", () -> new DibujoSolDemo().setVisible(true));
        agregarDemo(grilla, "14 - Arquitectura MVC", MVCTareasDemo::abrir);

        root.add(new JScrollPane(grilla), BorderLayout.CENTER);
        setContentPane(root);
    }

    private void agregarDemo(JPanel panel, String texto, Runnable accion) {
        JButton boton = AppStyles.botonPrimario(texto);
        boton.addActionListener(e -> accion.run());
        panel.add(boton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppStyles.aplicarLookAndFeel();
            new MainMenu().setVisible(true);
        });
    }
}
