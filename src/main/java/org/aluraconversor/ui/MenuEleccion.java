package org.aluraconversor.ui;

import javax.swing.*;
import java.awt.*;

public class MenuEleccion {
    
    private enum Opcion {
        CONVERSOR_MONEDA("Conversor de moneda", ConversorMoneda.class, new Dimension(824, 406)),
        CONVERSOR_TEMPERATURA("Conversor de temperatura", ConversorTemperatura.class, new Dimension(809, 256));
        
        private final String titulo;
        private final Class<? extends JFrame> clase;
        private final Dimension dimension;
        
        Opcion(String titulo, Class<? extends JFrame> clase, Dimension dimension) {
            this.titulo = titulo;
            this.clase = clase;
            this.dimension = dimension;
        }
    }

    private final Object[] opciones;
    private final String accion;
    private final String tituloMenu;

    public MenuEleccion(Object[] opciones, String accion, String tituloMenu) {
        this.opciones = opciones;
        this.accion = accion;
        this.tituloMenu = tituloMenu;
        menuInput();
    }

    private void menuInput() {
        Object opcionSeleccionada = JOptionPane.showInputDialog(null, accion, tituloMenu, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        for (Opcion opcion : Opcion.values()) {
            if (opcionSeleccionada.equals(opcion.titulo)) {
                mostrarFrame(opcion.clase, opcion.dimension);
                break;
            }
        }
    }

    private void mostrarFrame(Class<? extends JFrame> claseFrame, Dimension dimension) {
        SwingUtilities.invokeLater(() -> {
            try {
                JFrame frame = claseFrame.getDeclaredConstructor().newInstance();
                frame.setSize(dimension.width - 1, dimension.height - 1);
                frame.setMaximumSize(dimension);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
