/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Modelo;
import Vista.Vista;
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
    private Modelo modelo;
    private Vista vista;
    private ConexionBD conexion;
    public Controlador(Vista vista,Modelo modelo,ConexionBD conexion){
        this.modelo=modelo;
        this.vista=vista;
        this.conexion=conexion;
        initListeners();
    }   
    public void  initListeners(){
        vista.btnGuardar.addActionListener(e ->guardar());
        vista.btnEliminar.addActionListener(e ->eliminar());
        vista.btnLeer.addActionListener(e ->leer());
        vista.btnEditar.addActionListener(e ->editar());
        vista.btnConfirmarCambios.addActionListener(e->guardarCambios());
        vista.filtrarText.addKeyListener(new KeyListener() {
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
    public void eliminar(){
        int selectedItem=vista.tableData.getSelectedRow();
        if(selectedItem==0){
            DefaultTableModel tableModel=(DefaultTableModel)vista.tableData.getModel();
            String cedula=(String) tableModel.getValueAt(selectedItem, 0);
            if(cedula!=null&&cedula.isEmpty()){
                tableModel.removeRow(selectedItem);
                conexion.eliminar(cedula);
            }else{
                JOptionPane.showMessageDialog(vista, "No se pudo eliinar la celda");
            }
        }
    }
    public void leer(){
        DefaultTableModel model=(DefaultTableModel)vista.tableData.getModel();
        model.setRowCount(0);
        vista.tableData.setModel(conexion.leerDatosTabla());
    }
    public void guardar(){
        vista.tableData.setRowSorter(null);
        if(validateData()){
            String nombre=vista.nombreText.getText();
            String cedula=vista.cedulaText.getText();
            String genero=getGeneroSeleccionado();
            int edad=getEdadSeleccionada();
            DefaultTableModel tableModel=(DefaultTableModel)vista.tableData.getModel();
            tableModel.addRow(new Object[]{cedula,nombre,edad,genero});
            vista.tableData.setModel(tableModel);
            
            Modelo modelo=new Modelo(nombre,edad,genero,cedula);
            modelo.agregarDatos(modelo);
            limpiarVista();
            conexion.guardarDatos();
            
        }else{
            JOptionPane.showMessageDialog(vista,"Error,no se han ingresados todos los datos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void editar(){
        int selectedRow=vista.tableData.getSelectedRow();
        if(selectedRow==0){
            DefaultTableModel tableModel=(DefaultTableModel)vista.tableData.getModel();
            String cedula=(String)tableModel.getValueAt(selectedRow, 0);
            vista.cedulaText.setText(cedula);
            vista.cedulaText.setEnabled(false);
            
        }
    }
    public void guardarCambios(){
        int selectedItem=vista.tableData.getSelectedRow();
        if(selectedItem==0){
            DefaultTableModel tableModel=(DefaultTableModel)vista.tableData.getModel();
            String cedula=vista.cedulaText.getText();
            tableModel.setValueAt(cedula, selectedItem, 0);
        }
    }
    private String getGeneroSeleccionado(){
        return vista.rdbM.isSelected()?"Masculino":vista.rdbF.isSelected()?"Femenino":null;
    }
    private int getEdadSeleccionada(){
        return Integer.parseInt((String)vista.comboEdad.getSelectedItem());
    }
    private void limpiarVista(){
        vista.cedulaText.setText("");
        vista.nombreText.setText("");
        vista.errorCedula.setVisible(false);
        vista.errorGenero.setVisible(false);
        vista.errorNombre.setVisible(false);
    }
    private boolean validateData(){
        final String ERROR_NOMBRE_REQUIRED="Error, Nombre y a[ellido son requeridos";
        final String ERROR_NOMBRE_INVALID="Error: Nombre y apellido no validos";
        final String ERROR_CEDULA_REQUIRED="Error: Cedula es requerida";
        final String ERROR_CEDULA_INVALID="Error: La cedula debe tener 10 digitos";
        final String ERROR_GENERO_REQUIRED="Error: Edad es requerida";
        final String ERROR_EDAD_REQUIRED="Error: Edad es requerida";
        final String ERROR_EDAD_INVALID="Error: Edad no puede ser 0";
        boolean isValid=true;
        boolean allFieldsFilled=true;
        if(!vista.nombreText.getText().matches("\\p{L}+\\s\\p{L}+")){
            vista.errorNombre.setText(ERROR_NOMBRE_INVALID);
            vista.errorNombre.setVisible(true);
            isValid=false;
        }else if(vista.nombreText.getText().isEmpty()){
            vista.errorNombre.setText(ERROR_NOMBRE_REQUIRED);
            vista.errorNombre.setVisible(true);
            allFieldsFilled=false;
        }else{
            vista.errorNombre.setVisible(false);
        }
        if(!vista.cedulaText.getText().matches("\\d{10}")){
            vista.errorCedula.setText(ERROR_CEDULA_INVALID);
            vista.errorCedula.setVisible(true);
        }else if(vista.cedulaText.getText().isEmpty()){
            vista.errorCedula.setText(ERROR_CEDULA_REQUIRED);
            vista.errorCedula.setVisible(true);
            allFieldsFilled=false;
        }else{
            vista.errorCedula.setVisible(false);
        }
        if(!vista.rdbM.isSelected()&&!vista.rdbF.isSelected()){
            vista.errorGenero.setText(ERROR_GENERO_REQUIRED);
            vista.errorGenero.setVisible(true);
            allFieldsFilled=false;
        }else{
            vista.errorGenero.setVisible(false);
        }
        if(vista.comboEdad.getSelectedItem().equals("0")){
            vista.errorEdad.setText(ERROR_EDAD_INVALID);
            vista.errorEdad.setVisible(true);
        }else{
            vista.errorEdad.setVisible(false);
        }
        return isValid&&allFieldsFilled;
    }
    public void filtrar(){
        String text=vista.filtrarText.getText();
        TableRowSorter<TableModel>sorter=new TableRowSorter<>((TableModel)vista.tableData.getModel());
        vista.tableData.setRowSorter(sorter);
        RowFilter<TableModel,Object>filter=RowFilter.regexFilter(text,0);
        sorter.setRowFilter(filter);
        int viewRowCount=sorter.getViewRowCount();
        if(viewRowCount==0){
            JOptionPane.showMessageDialog(vista, "Error, no se encuentra la instruccion dicha");
        }
    }
}
