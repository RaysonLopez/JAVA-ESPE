/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2lab1lopezrayson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;




/**
 *
 * @author Rayson
 */
//Clase abstracta que define los atributos comunes de las demas clases hijas
public abstract class ProductoLopezRayson {
    protected String nombre;
    protected double precio,precioTotal;
    protected String codigo;
    protected String fechaCreacion;
    public ProductoLopezRayson(String nombre,double precio,String codigo,String fechaCreacion,double precioTotal) {
    	this.nombre=nombre;
    	this.precio=precio;
    	this.codigo=codigo;
		this.precioTotal=precioTotal;
    }
	
	public ProductoLopezRayson() {

	}
	//Metodo getter para obtener los valores de los atributos
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacío.");
		}
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		  if (precio < 0||precio >200000) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
	}
	
    public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		if (codigo == null || !codigo.matches("\\d{10}")) {
			throw new IllegalArgumentException("El código debe ser un número de 10 dígitos.");
		}
		this.codigo = codigo;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	//Metodo abstracto que deben implementar las clases hijas
	public abstract void IngresarDatos();
    public abstract void mostrarDetalles();
    public abstract double calcularImpuesto();
	public abstract double aplicarDescuento(double porcentaje);
}

