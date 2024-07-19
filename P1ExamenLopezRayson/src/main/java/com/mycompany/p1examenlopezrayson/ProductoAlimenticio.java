/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1examenlopezrayson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Rayson
 */
public class ProductoAlimenticio extends Producto{
     private String fechaExpiracion;
    private String categoria;
    static ArrayList<ProductoAlimenticio> productosAlimenticios = new ArrayList<>();
    public ProductoAlimenticio(String nombre, String codigo, String fechaCreacion, double precio) {
        super(nombre, codigo, fechaCreacion, precio);
    }

     @Override
    public void IngresarProducto() {
        super.IngresarProducto();
        System.out.println("Ingresa la fecha de expiración del producto (yyyy-MM-dd):");
        this.fechaExpiracion = sc.nextLine();
        System.out.println("Ingresa la categoría del producto:");
        this.categoria = sc.nextLine();

        productosAlimenticios.add(this);
        GuardarProductoCSV();
    }
    
    @Override
    public void GuardarProductoCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ProductosAlimenticios.csv", true))) {
            writer.write(this.obtenerDatosCSV());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
    @Override
    public String obtenerDatosCSV(){
        return nombre+","+codigo+","+fechaCreacion+","+precio;
    }

    Object getCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean ValidarVigenciaProducto(String fechaActual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
