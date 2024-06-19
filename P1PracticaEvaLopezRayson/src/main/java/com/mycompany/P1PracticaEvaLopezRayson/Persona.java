package com.mycompany.P1PracticaEvaLopezRayson;
import java.util.*;
import java.io.*;
public class Persona {
	private String nombres,apellidos,telf,CI;
	public Persona(String nombres,String apellidos,String telf,String CI) {
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.telf=telf;
		this.CI=CI;
	}
	public String getNombres() {
		return nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelf() {
		return telf;
	}
	public void setTelf(String telf) {
		this.telf = telf;
	}
	public String getCI() {
		return CI;
	}
	public void setCI(String cI) {
		CI = cI;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	 public void IngresarDatos() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Ingresa los nombres de la persona:");
	        this.nombres = scanner.nextLine();

	        System.out.println("Ingresa los apellidos de la persona:");
	        this.apellidos = scanner.nextLine();

	        System.out.println("Ingresa el telf de la persona:");
	        while (true) {
	            String input = scanner.nextLine();
	            if (input.matches("\\d{10}")) {
	                this.telf = input;
	                break;
	            } else {
	                System.out.println("Ingreso incorrecto, el teléfono debe tener 10 dígitos. Inténtalo de nuevo:");
	            }
	        }

	        System.out.println("Ingresa la cédula de la persona:");
	        while (true) {
	            String input = scanner.nextLine();
	            if (input.matches("\\d{10}")) {
	                this.CI = input;
	                break;
	            } else {
	                System.out.println("Ingreso inválido, la cédula debe tener 10 dígitos. Inténtalo nuevamente:");
	            }
	        }
	    }

	public void MostrarDatos() {
		System.out.println("Nombres: "+nombres);
		System.out.println("Apellidos: "+apellidos);
		System.out.println("telf: "+telf);
		System.out.println("CI: "+CI);
	}
	
}
