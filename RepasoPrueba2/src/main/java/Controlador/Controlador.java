/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Modelo;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rayson
 */
public class Controlador {
    Modelo model;
    Vista vista;
    ConexionBD conexion;
    public Controlador(Vista vista){
        this.model=new Modelo();
        this.vista=vista;
        this.conexion=new ConexionBD(model);
        vista.btnACTUALIZAR.addActionListener((ActionEvent e) -> {
            actualizar();
        });
        vista.btnELIMINAR.addActionListener((ActionEvent e) -> {
            eliminar();
        });
        vista.btnGUARDAR.addActionListener((ActionEvent e) -> {
            guardar();
        });
        vista.btnLEER.addActionListener((ActionEvent e) -> {
            leer();
        });
        vista.btnGuardarCambios.addActionListener((ActionEvent e) -> {
            guardarCambios();
        });
        vista.filtrar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                filtrar();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    public void guardar(){
        DefaultTableModel tableModel=(DefaultTableModel) vista.tableData.getModel();
        vista.tableData.setRowSorter(null);

         if(validateData()){
                     String nombre=vista.nombresText.getText();
        String cedula=vista.cedulaText.getText();
        String genero = null;
        if(vista.rdbMasculino.isSelected()){
            genero="Masculino";
        }else if(vista.rdbFemenino.isSelected()){
            genero="Fememino";
        }
        String seleccionado =(String) Vista.edadCombo.getSelectedItem();
        int edad=Integer.parseInt(seleccionado);
             tableModel.addRow(new Object[]{cedula,
                 nombre,
                 edad,
                 genero
             });
             vista.tableData.setModel(tableModel);
             Modelo modelo=new Modelo(nombre,edad,genero,cedula);
             model.agregarDatos(modelo);
             vista.errorCedula.setVisible(false);
             vista.errorGenero.setVisible(false);
             vista.errorNombres.setVisible(false);
             vista.cedulaText.setText("");
             vista.nombresText.setText("");
             conexion.guardarDatos();
         }else{
             JOptionPane.showMessageDialog(null,"Error, no se han ingresado todos los datos","Error",JOptionPane.ERROR_MESSAGE);
         }
    }
    public void filtrar(){
       String text=vista.filtrar.getText();
       TableRowSorter<TableModel>sorter=new TableRowSorter<>((TableModel)vista.tableData.getModel());
       vista.tableData.setRowSorter(sorter);
       RowFilter<TableModel,Object>filter=RowFilter.regexFilter(text, 0);
       sorter.setRowFilter(filter);
       //Verificar si el filtro encontro algun registro
       int viewRowCount=sorter.getViewRowCount();
       if(viewRowCount==0){
           JOptionPane.showMessageDialog(vista, "No se encontraros registros que estas buscando","Error",JOptionPane.ERROR_MESSAGE);
       }
    }
    public void actualizar(){
        int selectedRow=vista.tableData.getSelectedRow();
        if(selectedRow>=0){
            DefaultTableModel tableModel=(DefaultTableModel)vista.tableData.getModel();
            String cedula=(String)tableModel.getValueAt(selectedRow, 0);
            String nombre=(String)tableModel.getValueAt(selectedRow, 1);
            int edad=(Integer)tableModel.getValueAt(selectedRow, 2);
            String genero=(String)tableModel.getValueAt(selectedRow,3);
            
            vista.cedulaText.setText(cedula);
            vista.cedulaText.setEnabled(false);
            vista.nombresText.setText(nombre);
            Vista.edadCombo.setSelectedItem(edad);
            if(genero.equals("Masculino")){
                vista.rdbMasculino.setSelected(true);
                vista.rdbFemenino.setSelected(false);
            }else{
                vista.rdbFemenino.setSelected(true);
                vista.rdbMasculino.setSelected(false);
            }
            vista.btnGuardarCambios.setVisible(true);
            vista.btnGUARDAR.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(vista,"Seleccione una fila para actualizar");
        }
    }
    public void guardarCambios(){
        if(validateData()){
        int selectedRow=vista.tableData.getSelectedRow();
        if(selectedRow>=0){
            DefaultTableModel tableModel =(DefaultTableModel)vista.tableData.getModel();
            String cedula=vista.cedulaText.getText();
            String nombre=vista.nombresText.getText();
            String edadStr=(String)Vista.edadCombo.getSelectedItem();
            int edad=Integer.parseInt(edadStr);
            String genero = null;
            if(vista.rdbMasculino.isSelected()){
                genero="Masculino";
            }else if(vista.rdbFemenino.isSelected()){
                genero="Femenino";
            }
            
            tableModel.setValueAt(cedula, selectedRow, 0);
            tableModel.setValueAt(nombre,selectedRow,1);
            tableModel.setValueAt(edad,selectedRow,2);
            tableModel.setValueAt(genero, selectedRow,3);
            
            conexion.actualizarDatos(cedula, nombre, edad, genero);
            
            JOptionPane.showMessageDialog(vista,"Exito, se actualizaron los datos con exito");
            vista.btnGuardarCambios.setVisible(false);
            vista.btnGUARDAR.setVisible(true);  
            vista.cedulaText.setEnabled(true);
            vista.cedulaText.setText("");
            vista.nombresText.setText("");
        }else{
            JOptionPane.showMessageDialog(vista,"Error: seleccione una celda para modificar","Error",JOptionPane.ERROR_MESSAGE);
        }
        }else{
            JOptionPane.showMessageDialog(vista, "Error: ingrese todos los campos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void eliminar(){
        int selectedRow=vista.tableData.getSelectedRow();
        if(selectedRow>=0){
            DefaultTableModel tableModel=(DefaultTableModel) vista.tableData.getModel();
            String cedula=(String) tableModel.getValueAt(selectedRow, 0);
            if(cedula!=null&&!cedula.isEmpty()){
                tableModel.removeRow(selectedRow);
                conexion.eliminarDatos(cedula);
            }else{  
                JOptionPane.showConfirmDialog(vista,"Selecciona una fila para eliminar");
            }
            
        }
    }
    public void leer(){
        vista.tableData.setModel(conexion.leerDatosTabla());
    }

    public boolean validateData(){
        boolean isValid=true;
        boolean allFieldsFilled = true;

    if(vista.nombresText.getText().isEmpty()){
        vista.errorNombres.setText("Error: Nombre y apellido es requerido");
        vista.errorNombres.setVisible(true);
        allFieldsFilled = false;
    } else if(!vista.nombresText.getText().matches("[A-Za-z]+\\s[A-Za-z]+")){
        vista.errorNombres.setText("Error: Nombre y apellido no válido");
        vista.errorNombres.setVisible(true);
        isValid=false;
    } else {
        vista.errorNombres.setVisible(false);
    }

    if(vista.cedulaText.getText().isEmpty()){
        vista.errorCedula.setText("Error: Cédula es requerida");
        vista.errorCedula.setVisible(true);
        allFieldsFilled = false;
    } else if(!vista.cedulaText.getText().matches("\\d{10}")){
        vista.errorCedula.setText("Error: Cédula debe tener 10 dígitos");
        vista.errorCedula.setVisible(true);
        isValid=false;
    } else {
        vista.errorCedula.setVisible(false);
    }

    if(!vista.rdbMasculino.isSelected() && !vista.rdbFemenino.isSelected()){
        vista.errorGenero.setText("Error: Género es requerido");
        vista.errorGenero.setVisible(true);
        allFieldsFilled = false;
    } else if(vista.rdbMasculino.isSelected() && vista.rdbFemenino.isSelected()){
        vista.errorGenero.setText("Error: Género inconcluso");
        vista.errorGenero.setVisible(true);
        isValid=false;
    } else {
        vista.errorGenero.setVisible(false);
    }

    if(Vista.edadCombo.getSelectedItem().equals("0")){
        Vista.errorEdad.setText("Error: Edad no puede ser 0");
        Vista.errorEdad.setVisible(true);
        isValid=false;
    } else if(Vista.edadCombo.getSelectedItem().equals("")){
        Vista.errorEdad.setText("Error: Edad es requerida");
        Vista.errorEdad.setVisible(true);
        allFieldsFilled = false;
    } else {
        Vista.errorEdad.setVisible(false);
    }

        return allFieldsFilled && isValid;
}
}
