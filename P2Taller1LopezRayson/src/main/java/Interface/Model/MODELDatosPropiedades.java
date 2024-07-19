/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rayson
 */
public class MODELDatosPropiedades {
        private byte[]Image;
        private String nombres;
        private String descripcion;
        private String precio;
        private String metros;
        private String dirreccion;
        private String disponibilidad;
        private String numeroCuartos;
        private String ubicacion;
        List<MODELDatosPropiedades>propiedades;
        
    public MODELDatosPropiedades(byte[] Image, String nombres, String descripcion, String precio, String metros, String dirreccion, String disponibilidad, String numeroCuartos, String ubicacion) {
        this.Image = Image;
        this.nombres = nombres;
        this.descripcion = descripcion;
        this.precio = precio;
        this.metros = metros;
        this.dirreccion = dirreccion;
        this.disponibilidad = disponibilidad;
        this.numeroCuartos = numeroCuartos;
        this.ubicacion = ubicacion;
        this.propiedades=new ArrayList<>();
    }

    public List<MODELDatosPropiedades> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<MODELDatosPropiedades> propiedades) {
        this.propiedades = propiedades;
    }
    
    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMetros() {
        return metros;
    }

    public void setMetros(String metros) {
        this.metros = metros;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getNumeroCuartos() {
        return numeroCuartos;
    }

    public void setNumeroCuartos(String numeroCuartos) {
        this.numeroCuartos = numeroCuartos;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
        
}
