/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Redimensionador;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Rayson
 */
public class Redimensionador {
    
        public void  Redimensionador(JComponent componente, String ruta) {
        ImageIcon imagenFondo = cargarImagen(ruta);
        Icon fondoRedimensionado = redimensionarImagen(imagenFondo, componente.getWidth(), componente.getHeight());
        aplicarImagen(componente, fondoRedimensionado);}

    // Cargar la imagen desde la ruta especificada
    private ImageIcon cargarImagen(String ruta) {
        return new ImageIcon(getClass().getResource(ruta));
    }

    // Redimensionar la imagen a las dimensiones especificadas
    private Icon redimensionarImagen(ImageIcon imagen, int ancho, int alto) {
        return new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
    }

    // Aplicar la imagen al componente, si es un JLabel
    private void aplicarImagen(JComponent componente, Icon imagen) {
        if (componente instanceof JLabel) {
            ((JLabel) componente).setIcon(imagen);
        } else if (componente instanceof JButton) {
            ((JButton) componente).setIcon(imagen);
        } else {
            throw new IllegalArgumentException("El componente debe ser un JLabel o JButton");
        }
    }
}
