/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Controlador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rayson
 */
public class Modelo {
    private String nombres;
    private String cedula;
    private int edad;
    private String genero;
    List<Modelo>usuarios;

    public Modelo(String nombres, String cedula, int edad, String genero) {
        this.nombres = nombres;
        this.cedula = cedula;
        this.edad = edad;
        this.genero = genero;
        this.usuarios = new ArrayList<>();
    }
    public Modelo(){
        this.usuarios = new ArrayList<>();
    }
    public void guardarDatos(Modelo modelo){
        usuarios.add(modelo);
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public List<Modelo> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Modelo> usuarios) {
        this.usuarios = usuarios;
    }
    
   
}
