/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Controlador;

import MenuPrincipal.Controlador.ControladorMenuPrincipalCliente;
import Interface.ViewCliente.VISTAIngresoPropiedades;
import Interface.ViewCliente.PanelCliente;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


/**
 *
 * @author Rayson
 */
public class ControladorPanelCliente{
    PanelCliente view;
    
    public ControladorPanelCliente(PanelCliente view) {
        this.view = view;
        view.IniciarComponentes();
        view.PublicarButtom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                publicarBoton();
            }
        });
        view.ComprarButtom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarPropiedades();
            }
        });
        view.showPButtom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPropiedades();
            }
        });
    }   
    private void publicarBoton(){
        VISTAIngresoPropiedades propiedadNueva=new VISTAIngresoPropiedades();
        nuevoPanel(view.PanelClientePrincipal,propiedadNueva,"Panel de Propiedades");
    }    
    private void comprarPropiedades(){
        
    }
    private void mostrarPropiedades(){
        
    }

    public void nuevoPanel(JPanel panelActual,JPanel panelNext,String nombrePanel){
        System.out.println("Adding new panel: " + nombrePanel);
        panelActual.removeAll();
        panelActual.setLayout(new CardLayout());
        panelNext.setBounds(0,0,panelActual.getWidth(),panelActual.getHeight());
        panelActual.add(panelNext, nombrePanel);
        CardLayout layout = (CardLayout) panelActual.getLayout();
        layout.show(panelActual, nombrePanel);
        panelActual.repaint();
        panelActual.revalidate();
        System.out.println("Panel added: " + nombrePanel);
    }
}
