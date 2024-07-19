/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Controlador;

import InterfaceMenuPrincipalView.MenuPrincipalCliente;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rayson
 */
public class ControladorMenuPrincipal {
        private MenuPrincipalCliente menu=new MenuPrincipalCliente();
        private CardLayout cardLayout;
        public ControladorMenuPrincipal(){
            
        }
        public ControladorMenuPrincipal(MenuPrincipalCliente menu){
            this.menu=menu;
            this.cardLayout=(CardLayout)menu.PanelCambio.getLayout();
        }
        
        public void nuevoPanel(JPanel panelActual,JPanel panelNext,String nombrePanel){
        System.out.println("Adding new panel: " + nombrePanel);
        panelActual.removeAll();
        panelActual.add(panelNext, nombrePanel);
        CardLayout layout = (CardLayout) panelActual.getLayout();
        layout.show(panelActual, nombrePanel);
        panelActual.repaint();
        panelActual.revalidate();
        System.out.println("Panel added: " + nombrePanel);
    }
        public void MensajeConfirmacion(JFrame ventana){
                int confirm = JOptionPane.showOptionDialog(
            ventana,
            "¿Estás seguro de que quieres salir?",
            "Confirmación de salida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[]{"Sí", "No"},
            "No"
        );

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
