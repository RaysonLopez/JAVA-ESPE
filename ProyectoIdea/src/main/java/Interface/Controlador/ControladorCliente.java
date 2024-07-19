/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Controlador;

import Interface.Model.MODELDatosCLIENTE;
import Interface.ViewAdmin.VISTAPanelADMIN;
import Interface.ViewCliente.IngresoPropiedades;
import Interface.ViewCliente.PanelCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rayson
 */
public class ControladorCliente implements ActionListener{
    private VISTAPanelADMIN vista;
    private MODELDatosCLIENTE model;
    private PanelCliente panel;
    public ControladorCliente(){
        
    }
    public ControladorCliente(VISTAPanelADMIN vista, MODELDatosCLIENTE model,PanelCliente panel) {
        this.vista = vista;
        this.model = model; 
        this.panel=panel;
    }   
    private void PublicarBoton(){
        IngresoPropiedades propiedadNueva=new IngresoPropiedades();
        ControladorMenuPrincipal control=new ControladorMenuPrincipal();
        control.nuevoPanel(panel.PanelClientePrincipal,propiedadNueva,"Panel de Propiedades");
    }    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==panel.PublicarButtom){
            PublicarBoton();
        }else if(e.getSource()==panel.entrarButtom){
            
        }else if(e.getSource()==panel.ComprarButtom){
            
        }
    }
}
