/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Modelo;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rayson
 */
public class Controlador {
    Vista vista;
    Modelo model;
    ConexionBD conexion;
    public Controlador(Vista vista){
        this.vista=vista;
        this.model=new Modelo();
        this.conexion=new ConexionBD();
        vista.btnGUARDAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardar();
            }
        });
        vista.btnActualizar.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
            }
        });
        vista.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar();
            }
        });
        vista.btnGuardarCambios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
            }
        });
    }
    public void guardar(){
        DefaultTableModel tableModel=(DefaultTableModel) vista.tableData.getModel();
        if(validateData()){
        String nombre=vista.nombresText.getText();
        String cedula=vista.cedulaText.getText();
        String genero=null;
        String seleccionado=(String) vista.edadCombo.getSelectedItem();
        int edad=Integer.parseInt(seleccionado);
        if(vista.rdbMasculino.isSelected()){
            genero="Masculino";
        }else if(vista.rdbFemenino.isSelected()){
            genero="Femenino";
        }
        Modelo modelo=new Modelo(nombre, cedula, edad, genero);
        tableModel.addRow(new Object[]{nombre,cedula,genero,edad});
        model.guardarDatos(modelo);
        }else{
            JOptionPane.showMessageDialog(null,"Error, no se ingresan bien los datos");
        }
        
    }
    public boolean validateData(){
        boolean isValid=true;
        
        return isValid;
    }
    public void actualizar(){
        
    }
    public void eliminar(){
        int selectedItem=vista.tableData.getSelectedRow();
        if(selectedItem>=0){
            DefaultTableModel tableModel=new DefaultTableModel();
            tableModel=(DefaultTableModel) vista.tableData.getModel();
            tableModel.removeRow(selectedItem);
            vista.tableData.setModel(tableModel);
            String cedula=(String) vista.tableData.getValueAt(selectedItem, 0);
            conexion.eliminarDatos(cedula);
        }
    }
    public void guardarCambios(){
        
    }
}
