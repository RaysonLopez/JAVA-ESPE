/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Controlador;

import Interface.Model.MODELDatosADMIN;
import Interface.ViewAdmin.VISTABuscarClientesADMIN;
import Interface.ViewAdmin.VISTAIngresoADMIN;
import Interface.ViewAdmin.VISTAPanelADMIN;
import Interface.ViewAdmin.VISTAVerificarPropiedadesADMIN;
import MenuPrincipal.Controlador.ControladorMenuPrincipalCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;


/**
 *
 * @author Rayson
 */
public class ControladorAdmin  implements ActionListener{
    private VISTAIngresoADMIN view;
    private MODELDatosADMIN model;

    public ControladorAdmin(VISTAIngresoADMIN view,MODELDatosADMIN model){
        this.view=view;
        this.model=new MODELDatosADMIN();
    }
    public void GuardarDatos(){
        model.setNames(view.names.getText());
        model.setUsuario(view.cedula.getText());
        model.setPassword(view.contrasenia.getText());
        
    }
    public void modificateData(VISTAIngresoADMIN cliente){
        
    }
    public void chanceLanguaje(){
               String selectedLanguage = (String) view.languaje.getSelectedItem();
        if ("Español".equals(selectedLanguage)) {
            // Configurar los textos en español
            view.NombresLabel.setText("Nombre y Apellido");
            view.idLabel.setText("ID");
            view.errorContra.setText("Email incorrecto");
            view.saveTable.setText("GUARDAR");
            view.deleteTable.setText("ELIMINAR");
            view.ModificateTable.setText("MODIFICAR");
        } else if ("English".equals(selectedLanguage)) {
            // Configurar los textos en inglés
            view.NombresLabel.setText("Full Name");
            view.idLabel.setText("ID");
            view.errorNames.setText("Error: must have a first and last name");
            view.errorId.setText("Incorrect ID");
            view.saveTable.setText("SAVE");
            view.deleteTable.setText("DELETE");
            view.ModificateTable.setText("MODIFY");
        }

        // Forzar la actualización de la interfaz
        view.revalidate();
        view.repaint();
    }
    public File AdjuntarImagen(VISTAIngresoADMIN cliente){
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter(){
           @Override
           public boolean accept(File f){
               return f.getName().endsWith(".jpg")||f.getName().endsWith(".jpeg")||f.getName().endsWith(".png");
           }
           @Override
           public String getDescription(){
            return "Imagenes(jpg, jpeg, png)";
        }
        });
        int returnVal=fileChooser.showOpenDialog(cliente);
        if(returnVal==JFileChooser.APPROVE_OPTION){
            File file=fileChooser.getSelectedFile();
            return file;
        }else{
            return null;
        }
    }
    public void deleteData(){
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == view.saveTable) {
            // Llamar al método para guardar los datos
            GuardarDatos();
        } else if (e.getSource() == view.deleteTable) {
            // Llamar al método para eliminar los datos
            deleteData();
        } else if (e.getSource() == view.ModificateTable) {
            // Llamar al método para modificar los datos
            modificateData(view);
        } else if (e.getSource() == view.languaje) {
            // Llamar al método para cambiar el idioma
            chanceLanguaje();
        }
    }
    

}
