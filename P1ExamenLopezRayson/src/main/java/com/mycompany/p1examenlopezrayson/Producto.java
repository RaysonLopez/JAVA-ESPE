/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1examenlopezrayson;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rayson
 */
public class Producto {
    String nombre;
    String codigo;
    String fechaCreacion;
    double precio;
    static final Scanner sc = new Scanner(System.in);
    
    public Producto(String nombre, String codigo, String fechaCreacion, double precio){
        this.nombre=nombre;
        this.codigo=codigo;
        this.fechaCreacion=fechaCreacion;
        this.precio=precio;
    }
    public void IngresarProducto(){
        System.out.println("Ingresa el nombre del producto");
        this.nombre=sc.nextLine();
        System.out.println("Ingresa el codigo del producto");
        this.codigo=sc.nextLine();
        System.out.println("Ingresa la fecha del producto" );
        this.fechaCreacion=sc.nextLine();
        System.out.println("Ingresa el precio del producto");
        this.precio=sc.nextDouble();
    }
    public void GuardarProductoCSV(){
        
    }
    public void GuardarDatosJson(ArrayList<Producto>p,ArrayList<Producto>e){

    }
    public String obtenerDatosCSV() {
        return nombre + "," + codigo + "," + fechaCreacion + "," + precio;
    }
}
