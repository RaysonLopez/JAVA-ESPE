/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Controlador;

import ConexionBD.ConexionBDClientes;
import Interface.Model.MODELDatosADMIN;
import Interface.ViewAdmin.VISTAIngresoADMIN;
import Interface.Model.MODELDatosCLIENTE;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Rayson
 */
public class ControladorAdmin  implements ActionListener{
    private VISTAIngresoADMIN vista;
    private MODELDatosADMIN model;
    public ControladorAdmin(VISTAIngresoADMIN vista,MODELDatosADMIN model){
        this.vista=vista;
        this.model=new MODELDatosADMIN();
    }
    public void GuardarDatos(){
        model.setNames(vista.names.getText());
        model.setUsuario(vista.cedula.getText());
        model.setPassword(vista.contrasenia.getText());
        
    }
    public void modificateData(VISTAIngresoADMIN cliente){
        
    }
    public void chanceLanguaje(){
               String selectedLanguage = (String) vista.languaje.getSelectedItem();
        if ("Español".equals(selectedLanguage)) {
            // Configurar los textos en español
            vista.NombresLabel.setText("Nombre y Apellido");
            vista.idLabel.setText("ID");
            vista.errorContra.setText("Email incorrecto");
            vista.saveTable.setText("GUARDAR");
            vista.deleteTable.setText("ELIMINAR");
            vista.ModificateTable.setText("MODIFICAR");
        } else if ("English".equals(selectedLanguage)) {
            // Configurar los textos en inglés
            vista.NombresLabel.setText("Full Name");
            vista.idLabel.setText("ID");
            vista.errorNames.setText("Error: must have a first and last name");
            vista.errorId.setText("Incorrect ID");
            vista.saveTable.setText("SAVE");
            vista.deleteTable.setText("DELETE");
            vista.ModificateTable.setText("MODIFY");
        }

        // Forzar la actualización de la interfaz
        vista.revalidate();
        vista.repaint();
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
         if (e.getSource() == vista.saveTable) {
            // Llamar al método para guardar los datos
            GuardarDatos();
        } else if (e.getSource() == vista.deleteTable) {
            // Llamar al método para eliminar los datos
            deleteData();
        } else if (e.getSource() == vista.ModificateTable) {
            // Llamar al método para modificar los datos
            modificateData(vista);
        } else if (e.getSource() == vista.languaje) {
            // Llamar al método para cambiar el idioma
            chanceLanguaje();
        }
    }
}
