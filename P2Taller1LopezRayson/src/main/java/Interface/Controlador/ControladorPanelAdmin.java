/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Controlador;

import Interface.ViewAdmin.VISTABuscarClientesADMIN;
import Interface.ViewAdmin.VISTAIngresoADMIN;
import Interface.ViewAdmin.VISTAPanelADMIN;
import Interface.ViewAdmin.VISTAVerificarPropiedadesADMIN;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Rayson
 */
public class ControladorPanelAdmin {
        private VISTAPanelADMIN view;
        public ControladorPanelAdmin(VISTAPanelADMIN view){
            this.view=view;
            
        }
            public void PanelEntrarVerificar(){
                VISTAVerificarPropiedadesADMIN panelVerificar=new VISTAVerificarPropiedadesADMIN();
        nuevoPanel(view.PanelAdmin, panelVerificar, "Panel de Verificar Publicaciones");
    }
    public void PanelBuscarUsuarios(){
        VISTABuscarClientesADMIN panelClientes=new VISTABuscarClientesADMIN();
        nuevoPanel(view.PanelAdmin,panelClientes , "Menu de Buscar Clientes");
    }
    public void PanelCrearUsuarios(){
        VISTAIngresoADMIN panelIngreso=new VISTAIngresoADMIN();
    nuevoPanel(view.PanelAdmin,panelIngreso,"Panel de Creacion De Usuarios");
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
}
