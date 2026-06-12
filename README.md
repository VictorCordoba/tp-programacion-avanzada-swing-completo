# Programación Avanzada - Trabajo Práctico Swing Completo

**Alumno:** Victor Cordoba  
**Legajo:** 114045  
**Materia:** Programación Avanzada  
**Universidad:** Universidad del Aconcagua

## Descripción

Este proyecto desarrolla una serie de clases individuales en Java Swing basadas en los ejemplos del apunte **Swing Completo**. Cada ejemplo fue rearmado y mejorado con una interfaz más ordenada, validaciones simples, mensajes al usuario y una estructura de código más clara.

El proyecto fue preparado para abrirse en **Apache NetBeans** como proyecto Java con Ant.

## Temas incluidos

- Creación de ventanas con `JFrame`.
- Componentes básicos: `JButton`, `JLabel`, `JTextField`, `JCheckBox` y `JRadioButton`.
- Layout managers: `FlowLayout`, `GridLayout`, `BorderLayout` y `GridBagLayout`.
- Uso de `JPanel` para construir interfaces más complejas.
- Manejo de eventos con `ActionListener`, `DocumentListener`, `WindowListener`, `MouseListener` y `KeyListener`.
- Cuadros de diálogo con `JOptionPane`.
- Dibujo personalizado con `paintComponent(Graphics g)`.
- Separación básica Modelo - Vista - Controlador (MVC).

## Clases principales desarrolladas

| Clase | Tema trabajado | Mejora incorporada |
|---|---|---|
| `MainMenu` | Menú principal | Permite abrir todos los ejemplos desde una sola ventana. |
| `VentanaBasicaDemo` | `JFrame` | Ventana centrada, texto explicativo y cierre controlado. |
| `ComponentesBasicosDemo` | Componentes | Integra botones, campos, checkboxes y radios en un mini formulario. |
| `FlowLayoutDemo` | `FlowLayout` | Agrega validación de campo vacío antes de saludar. |
| `GridLayoutDemo` | `GridLayout` | Simula un teclado interactivo con visor. |
| `BorderLayoutDemo` | `BorderLayout` | Muestra zonas visuales NORTH, SOUTH, EAST, WEST y CENTER. |
| `JPanelComplejoDemo` | `JPanel` compuesto | Formulario de usuario con panel de fecha y validaciones. |
| `GridBagLayoutDemo` | `GridBagLayout` | Formulario flexible de incidencias. |
| `EventosBotonDemo` | `ActionListener` | Botón con contador de pulsaciones y cambio de texto. |
| `EventosSaludoReferenciaDemo` | Acceso a componentes | El manejador recibe un `JTextField` para leer el nombre. |
| `EventosTextoDocumentDemo` | Eventos de texto | Validación en tiempo real del nombre de usuario. |
| `EventosVentanaMouseTecladoDemo` | Eventos varios | Log de eventos de ventana, mouse y teclado. |
| `DialogosDemo` | `JOptionPane` | Prueba de mensaje, entrada y confirmación. |
| `DibujoSolDemo` | Dibujo gráfico | Dibujo mejorado usando `Graphics2D` y antialiasing. |
| `MVCTareasDemo` | MVC | Mini gestor de tareas separado en modelo, vista y controlador. |

## Cómo abrirlo en NetBeans

1. Abrir Apache NetBeans.
2. Ir a **File > Open Project**.
3. Seleccionar la carpeta `ProgramacionAvanzadaSwingCompleto`.
4. Abrir el proyecto.
5. Ejecutar la clase principal `programacionavanzada.swingcompleto.MainMenu`.

También se puede ejecutar cada clase individual desde el paquete `programacionavanzada.swingcompleto.ejemplos` usando **Run File**.

## Cómo compilar desde consola

```bash
ant clean jar
```

El `.jar` generado queda en:

```text
dist/ProgramacionAvanzadaSwingCompleto.jar
```

## Estructura general

```text
ProgramacionAvanzadaSwingCompleto/
├── src/
│   └── programacionavanzada/
│       └── swingcompleto/
│           ├── MainMenu.java
│           ├── util/
│           │   └── AppStyles.java
│           └── ejemplos/
│               ├── VentanaBasicaDemo.java
│               ├── ComponentesBasicosDemo.java
│               ├── FlowLayoutDemo.java
│               ├── GridLayoutDemo.java
│               ├── BorderLayoutDemo.java
│               ├── JPanelComplejoDemo.java
│               ├── GridBagLayoutDemo.java
│               ├── EventosBotonDemo.java
│               ├── EventosSaludoReferenciaDemo.java
│               ├── EventosTextoDocumentDemo.java
│               ├── EventosVentanaMouseTecladoDemo.java
│               ├── DialogosDemo.java
│               ├── DibujoSolDemo.java
│               └── mvc/
│                   ├── Tarea.java
│                   ├── TareaModel.java
│                   ├── TareaView.java
│                   ├── TareaController.java
│                   └── MVCTareasDemo.java
├── nbproject/
├── build.xml
└── README.md
```
