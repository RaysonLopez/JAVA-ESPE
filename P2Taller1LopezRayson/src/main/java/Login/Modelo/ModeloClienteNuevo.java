/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rayson
 */
public class ModeloClienteNuevo {
    private String CI;
    private String contra;
    private String nombres; 
    private String telf;
    private String mail;
    private String genero;
    private String diaB;
    private String mesB;
    private String anioB;
    private String fecha;
    private byte[] Imagen;
    List<ModeloClienteNuevo> clientes;
    public ModeloClienteNuevo(String CI, String contra, String nombres, String telf, String mail, String genero,String fecha, byte[] Imagen) {
        this.CI = CI;
        this.contra = contra;
        this.nombres = nombres;
        this.telf = telf;
        this.mail = mail;
        this.genero = genero;
        this.fecha=fecha;
        this.Imagen = Imagen;
    }
        public ModeloClienteNuevo(){
        this.clientes = new ArrayList<>();
    }
    public List<ModeloClienteNuevo> getClientes() {
        return clientes;
    }

    public void setClientes(List<ModeloClienteNuevo> clientes) {
        this.clientes = clientes;
    }

     
    public void agregarCliente(ModeloClienteNuevo cliente) {
        this.clientes.add(cliente); // Agregar un elemento a la lista
    }
    

    

    public byte[] getImagen() {
        return Imagen;
    }

    public void setImagen(byte[] Imagen) {
        this.Imagen = Imagen;
    }
    
    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiaB() {
        return diaB;
    }

    public void setDiaB(String diaB) {
        this.diaB = diaB;
    }

    public String getMesB() {
        return mesB;
    }

    public void setMesB(String mesB) {
        this.mesB = mesB;
    }

    public String getAnioB() {
        return anioB;
    }

    public void setAnioB(String anioB) {
        this.anioB = anioB;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
