package programacionavanzada.swingcompleto.ejemplos.mvc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import programacionavanzada.swingcompleto.util.AppStyles;

public class TareaView extends JFrame {
    private final JTextField campoTarea = new JTextField(24);
    private final JButton botonAgregar = AppStyles.botonPrimario("Agregar");
    private final JButton botonCompletar = AppStyles.botonPrimario("Marcar completada");
    private final JButton botonEliminar = AppStyles.botonPrimario("Eliminar");
    private final JList<Tarea> lista = new JList<>();

    public TareaView() {
        super("14 - Arquitectura MVC");
        AppStyles.configurarVentana(this, 620, 430);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        AppStyles.agregarMargen(root);
        root.setBackground(AppStyles.GRIS_FONDO);
        root.add(AppStyles.titulo("MVC: Modelo, Vista y Controlador"), BorderLayout.NORTH);

        JPanel superior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        superior.setOpaque(false);
        superior.add(campoTarea);
        superior.add(botonAgregar);
        root.add(superior, BorderLayout.CENTER);

        JPanel panelLista = AppStyles.panelConTitulo("Tareas del proyecto");
        panelLista.add(new JScrollPane(lista), BorderLayout.CENTER);
        root.add(panelLista, BorderLayout.SOUTH);

        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        acciones.setOpaque(false);
        acciones.add(botonCompletar);
        acciones.add(botonEliminar);
        panelLista.add(acciones, BorderLayout.SOUTH);
        setContentPane(root);
    }

    public JTextField getCampoTarea() {
        return campoTarea;
    }

    public JButton getBotonAgregar() {
        return botonAgregar;
    }

    public JButton getBotonCompletar() {
        return botonCompletar;
    }

    public JButton getBotonEliminar() {
        return botonEliminar;
    }

    public JList<Tarea> getLista() {
        return lista;
    }
}
