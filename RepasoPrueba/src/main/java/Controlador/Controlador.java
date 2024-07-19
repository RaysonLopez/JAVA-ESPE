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
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Rayson
 */
public class Controlador {
    
    private Modelo model;
    private Vista view;
    
    public Controlador(Vista view){
        this.view=view;
        this.model=new Modelo();
        view.guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardar();
            }
        });
        view.eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar();
            }
        });
        view.modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificar();
            }
        });
        view.leerJSON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerJson();
            }
        });
    }
    public void guardar(){
        if(validateData()){
         DefaultTableModel tableModel=(DefaultTableModel)view.tabla.getModel();
        String nombres=view.nombresProducto.getText();
        double precio=Double.parseDouble(view.precio.getText());
        long codigo=Long.parseLong(view.codigo.getText());
        String categoria=(String)view.categoria.getSelectedItem();
        Modelo model=new Modelo(codigo,nombres, precio,categoria);
        tableModel.addRow(new Object[]{codigo,nombres,precio,categoria});
        view.codigo.setText("");
        view.nombresProducto.setText("");
        view.precio.setText("");
        ConexionBD conexion=new ConexionBD(model);
        conexion.GuardarDatos();
        }else{
            JOptionPane.showMessageDialog(null,"Error, no se han ingresado los datos","Error",JOptionPane.ERROR_MESSAGE);
        } 
    }
    public void modificar(){
                int selectedRow=view.tabla.getSelectedRow();
        if(selectedRow>=0&&validateData()){
            DefaultTableModel tableModel=(DefaultTableModel)view.tabla.getModel();
            String nombres=view.nombresProducto.getText();
            double precio=Double.parseDouble(view.precio.getText());
            int codigo=Integer.parseInt(view.codigo.getText());
            
            tableModel.setValueAt(codigo,selectedRow,0);
            tableModel.setValueAt(nombres,selectedRow,1);
            tableModel.setValueAt(precio,selectedRow, 2);
            JOptionPane.showMessageDialog(null,"datos modificados");
        }else{
            JOptionPane.showMessageDialog(null,"Error, no se ha seleccionado alguna fila");
        }
    }
    public void eliminar(){
        int selectedRow=view.tabla.getSelectedRow();
        if(selectedRow>=0){
            DefaultTableModel tableModel=(DefaultTableModel)view.tabla.getModel();
            Long codigo=(Long)view.tabla.getValueAt(selectedRow,0);
            tableModel.removeRow(selectedRow);
            ConexionBD conexion=new ConexionBD(model);
            conexion.eliminarDatos(codigo);
            JOptionPane.showMessageDialog(null,"datos eliminados");
        }else{
            JOptionPane.showMessageDialog(null,"Error, no se ha seleccionado una fila");
        }
    }
    public boolean validateData(){
        boolean isValid=true;
        if(view.nombresProducto.getText().isEmpty()){
            view.errorNombres.setText("Ingresa campos validos");
            view.errorNombres.setVisible(true);
            isValid=false;
        }else{
            view.errorNombres.setVisible(false);
            isValid=true;
        }
        if(view.precio.getText().isEmpty()||view.precio.getText().matches("\\d+^.\\d+^")){
            view.errorPrecio.setText("ErrorL Debes Ingresar Datos o solo numeros decimales");
            view.errorPrecio.setVisible(true);
            isValid=false; 
        }else{
            view.errorPrecio.setVisible(false);
            isValid=true;
        }
        if(view.codigo.getText().isEmpty()||view.codigo.getText().matches("\\d{10}+^")){
            view.errorCodigo.setText("Error, Debes ingresar datos o solo numeros enteros");
            view.errorCodigo.setVisible(true);
            isValid=false;
        }else{
            view.errorCodigo.setVisible(false);
            isValid=true;
        }
    return isValid;
}      
        public DefaultTableModel actualizarTabla(){
            DefaultTableModel tableModel=(DefaultTableModel)view.tabla.getModel();
            tableModel.setRowCount(0);
             ConexionBD conexion=new ConexionBD(model);
             List<Modelo>datos=conexion.leerdatos();
             for(Modelo dato:datos){
                 tableModel.addRow(new Object[]{dato.getCodigo(),dato.getNombres(),dato.getPrecio(),dato.getCategoria()});
             }
             return tableModel;
        }
         public void leerJson(){
            JSONParser parser=new JSONParser();
            try(FileReader file=new FileReader("C:\\Users\\Rayson\\Escritorio\\JAVA\\RepasoPrueba\\productos_aleatorios.json")) {
                Object obj=parser.parse(file);
                JSONArray jsonArray=(JSONArray)obj;
                
                DefaultTableModel tableModel=(DefaultTableModel)view.tabla.getModel();
                tableModel.setRowCount(0);
                for(Object jsonObject:jsonArray){
                    JSONObject objeto=(JSONObject)jsonObject;
                    String nombres=(String)objeto.get("Nombres");
                    double precio=(double)objeto.get("Precio");
                    long codigo=(long)objeto.get("Codigo");
                    String categoria=(String)objeto.get("Categoria");
                    
                    Modelo dato=new Modelo(codigo,nombres,precio,categoria);
                    tableModel.addRow(new Object[]{dato.getCodigo(),dato.getNombres(),dato.getPrecio(),dato.getCategoria()});
                }
            }catch(IOException|ParseException e){
                e.printStackTrace();    
            }
         }
}
