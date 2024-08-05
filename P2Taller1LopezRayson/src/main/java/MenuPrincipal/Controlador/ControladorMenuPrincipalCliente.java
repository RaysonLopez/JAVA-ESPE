/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuPrincipal.Controlador;

import Interface.ViewCliente.BuscarPropiedades;
import Interface.ViewCliente.PanelCliente;
import Login.Vista.VistaLogin;
import MenuPrincipal.View.MenuPrincipalCliente;
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
public class ControladorMenuPrincipalCliente implements ActionListener{
        private MenuPrincipalCliente view;
        private CardLayout cardLayout;
        public ControladorMenuPrincipalCliente(MenuPrincipalCliente view){
            this.view=view;
            view.iniciarComponentes();
            view.inicioMenu.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    inicioMenu();
                }
            });
            view.buscarMenu.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buscarMenu();
                }
            });
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
            this.cardLayout=(CardLayout)view.PanelCambio.getLayout();
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
        private void backMenu(){
                    // Ocultar la ventana actual
        view.setVisible(false);
        // Crear y mostrar la ventana de login
        new VistaLogin().setVisible(true);
        }
        private void buscarMenu(){
        BuscarPropiedades buscarP=new BuscarPropiedades();
        nuevoPanel(view.PanelCambio, buscarP, "Panel de Buscar");
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
        private void inicioMenu(){
        PanelCliente panelCliente=new PanelCliente();
        nuevoPanel(view.PanelCambio, panelCliente, "Panel Del Cliente");
        }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view.backMenu){
           backMenu(); 
        }else if(e.getSource()==view.buscarMenu){
            buscarMenu();
        }else if(e.getSource()==view.exitMenuAdd){
            exitMenu();
        }else if(e.getSource()==view.inicioMenu){
            inicioMenu();
        }
    }
}
