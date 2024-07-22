/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rayson
 */
public class Modelo {
    private String nombres;
    private int edad;
    private String genero;
    private String cedula;
    private List<Modelo>clientes;
    public Modelo(String nombres,int edad,String genero,String cedula){
        this.nombres=nombres;
        this.edad=edad;
        this.genero=genero;
        this.cedula=cedula;
    }
    public Modelo(){
        this.clientes=new ArrayList<>();
    }
    public void agregarDatos(Modelo modelo){
        clientes.add(modelo);
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Modelo> getClientes() {
        return clientes;
    }

    public void setClientes(List<Modelo> clientes) {
        this.clientes = clientes;
    }
    
}
