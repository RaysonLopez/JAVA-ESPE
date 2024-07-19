/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuPrincipal.Controlador;

import Interface.ViewAdmin.VISTAPanelADMIN;
import Login.Vista.VistaLogin;
import MenuPrincipal.View.MenuPrincipalAdmin;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rayson
 */
public class ControladorMenuPrincipalAdmin {
    MenuPrincipalAdmin view;
    public ControladorMenuPrincipalAdmin(MenuPrincipalAdmin view){
        this.view=view;
        view.IniciarComponentes();
        view.backMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backMenu();
            }
        });
        view.exitMenuAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitMenu();
            }
        });
        view.inicioMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                inicioMenu();
            }
        });
    }  
    public void MensajeConfirmacion(){
                int confirm = JOptionPane.showOptionDialog(
            view,
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
        public void backMenu(){
          // Ocultar la ventana actual
        view.setVisible(false);
        // Crear y mostrar la ventana de login
        new VistaLogin().setVisible(true);
            }
        public void inicioMenu(){
                       VISTAPanelADMIN panelAdmin=new VISTAPanelADMIN();
        nuevoPanel(view.PanelCambio, panelAdmin, "Panel Del Cliente");
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
       private void exitMenu(){
                    int confirm = JOptionPane.showOptionDialog(
            view,
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

