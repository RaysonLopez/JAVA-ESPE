/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Controlador;

import ConexionBD.ConexionBDPropiedades;
import Interface.Model.MODELDatosPropiedades;
import Interface.ViewCliente.VISTAIngresoPropiedades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rayson
 */
public class ControladorIngresoPropiedadesCLIENTE implements ActionListener {
    MODELDatosPropiedades model;
    VISTAIngresoPropiedades view;
    ConexionBDPropiedades conexion;
    public ControladorIngresoPropiedadesCLIENTE(MODELDatosPropiedades model,VISTAIngresoPropiedades view){
        this.model=model;
        this.view=view;
    }
    private void saveTable(){
        String nombres=view.namesPropiedad.getText();
        String descripcion=view.descripcionText.getText();
        String precio=view.precioText.getText();
        String metros=view.metrosText.getText();
        String dirreccion=view.dirreccionText.getText();
        String disponibilidad=view.disponibilidadCombo.getSelectedItem().toString();
        String numeroCuartos=view.numeroCuartosCombo.getSelectedItem().toString();
        String ubicacion=view.ubicacionCombo.getSelectedItem().toString();
        boolean valid = true;

        if (!nombres.matches("[A-Za-z]+\\s[A-Za-z]+")) {
            view.errorNames.setText("Error: tiene que tener un nombre y un apellido");
            view.errorNames.setVisible(true);
            valid = false;
        } else {
            view.errorNames.setVisible(false);
        }

        if (descripcion.isEmpty()) {
            view.errorDescripcion.setText("Error: descripcion no puede estar vacia");
            view.errorDescripcion.setVisible(true);
            valid = false;
        } else {
            view.errorDescripcion.setVisible(false);
        }

        if (dirreccion.isEmpty()) {
            view.errorDirrecion.setText("Error: dirreccion no puede estar vacia");
            view.errorDirrecion.setVisible(true);
            valid = false;
        } else {
            view.errorDirrecion.setVisible(false);
        }

        if (!precio.matches("^\\d+(\\.\\d{1,2})?$")) {
            view.errorPrecio.setText("Error: debe ser un numero decimal");
            view.errorPrecio.setVisible(true);
            valid = false;
        } else {
            view.errorPrecio.setVisible(false);
        }

        if (!metros.matches("^\\d+(\\.\\d{1,2})?$")) {
            view.errorMetros.setText("Error: debe ser un numero decimal");
            view.errorMetros.setVisible(true);
            valid = false;
        } else {
            view.errorMetros.setVisible(false);
        }

        if (valid) {
            DefaultTableModel tableModel = (DefaultTableModel) view.dataTable.getModel();
            int rowCount = tableModel.getRowCount();
            boolean duplicate = false;

            for (int i = 0; i < rowCount; i++) {
                String existingNombres = tableModel.getValueAt(i, 1).toString();

                if (nombres.equals(existingNombres)) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                JOptionPane.showMessageDialog(view, "Error: El Nombre De La Propiedad no puede ser lo mismo.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] camposT = {nombres, descripcion, precio, metros, dirreccion,disponibilidad,numeroCuartos,ubicacion};
                tableModel.addRow(camposT);

                // Limpiar los campos de entrada
                view.namesPropiedad.setText("");
                view.descripcionText.setText("");
                view.precioText.setText("");
                view.metrosText.setText("");
                view.dirreccionText.setText("");
                view.disponibilidadCombo.setSelectedIndex(0);
                view.numeroCuartosCombo.setSelectedIndex(0);
                view.ubicacionCombo.setSelectedIndex(0);// Reiniciar el combo box de género
            }
        }  
    }
        private void eliminarCelda(){
        DefaultTableModel tableModel = (DefaultTableModel) view.dataTable.getModel();
        int[] selectedRows = view.dataTable.getSelectedRows();

        // Eliminar las filas seleccionadas del modelo de la tabla
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            tableModel.removeRow(selectedRows[i]);
        }
        }
        private void ModificarTabla(){
                // Obtener los valores actualizados de los campos
    String nombre = view.namesPropiedad.getText();
    String descripcion = view.descripcionText.getText();
    String dirreccion = view.dirreccionText.getText();
    String precio = view.precioText.getText();
    String metros = view.metrosText.getText();
    String numeroCuartos = view.numeroCuartosCombo.getSelectedItem().toString();
    String ubicacion = view.ubicacionCombo.getSelectedItem().toString();
    String disponibilidad = view.disponibilidadCombo.getSelectedItem().toString();
    String []datos={nombre, descripcion, dirreccion, precio, metros, numeroCuartos, ubicacion, disponibilidad};
    // Llamar al método modificarCliente()
    conexion.actualizarDatos(datos);
        }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view.saveTable){
            saveTable();
        }else if(e.getSource()==view.deleteTable){
            eliminarCelda();
        }
    }
    
}
