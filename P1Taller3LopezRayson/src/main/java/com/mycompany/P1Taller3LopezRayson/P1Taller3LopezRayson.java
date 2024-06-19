package com.mycompany.P1Taller3LopezRayson;

import java.util.Scanner;

public class P1Taller3LopezRayson {
	public static void main(String[] args) {
		MenuPrincipal();
		
	}
	public static void MenuPrincipal() {
		Scanner scanner= new Scanner(System.in);
		
		
		char OPC;
		do {
		System.out.println("BASE DE DATOS ESPE");
		System.out.println("1. Estudiantes");
		System.out.println("2. Profesores");
		System.out.println("3. Salir");
		OPC=scanner.next().charAt(0);
		switch(OPC) {
		case '1':
			OPC1();
			break;
		case '2':
			OPC2();
		case '3':
			System.out.println("saliendo..............");
		}
		}while(OPC!='3');
	}
	public static void OPC1(){
		Estudiante_LopezRayson estudiante= new Estudiante_LopezRayson(null, null, 0, null, null);
		Scanner scanner= new Scanner(System.in);
		char OPC;
		do {
		System.out.println("ESTUDIANTES");
		System.out.println("1. Ingreso Datos Estudiantes");
		System.out.println("2. Mostrar Datos Estudiantes (Archivo JSON)");
		System.out.println("3. Modificar Datos Estudiantes");
		System.out.println("4. Eliminar Estudiante");
		System.out.println("5. Salir");
		OPC=scanner.next().charAt(0);
		switch(OPC) {
		case '1':
			System.out.println("Ingreso Datos Estudiantes");
			estudiante.IngresarDatos();
			estudiante.DatosAlJSON();
			break;
		case '2':
			System.out.println("Opcion Mostrar Datos");
			estudiante.MostrarDatosJSON();
			break;
		case '3':
			System.out.println("Opcion Modificar Estudiantes");
			estudiante.modificarDatosJSON();
			break;
		case '4': 
			System.out.println("Opcion Eliminar Estudiante");
			estudiante.EliminarDatosJSON();
			break;
		case '5':
			System.out.println("Saliendo..............");
			default: System.out.println("Opcion incorrecta......");
			break;
		}
	}while(OPC!='5');
}
	public static void OPC2() {
		char OPC;
		Scanner scanner= new Scanner(System.in);
		Profesor_LopezRayson profesor=new Profesor_LopezRayson(null, null, 0, 0, 0);
		do {
			System.out.println("PROFESORES");
			System.out.println("1. Ingreso Datos Profesores");
			System.out.println("2. Mostrar Datos Profesores(Archivo CSV)");
			System.out.println("3. Modificar Datos Profesores");
			System.out.println("4. Eliminar Profesores");
			System.out.println("5. Salir");
			OPC=scanner.next().charAt(0);
			switch(OPC) {
			case '1':
				System.out.println("Ingreso Datos Profesores");
				profesor.IngresarDatos();
				profesor.DatosAlCSV();
				break;
			case '2':
				System.out.println("Mostrar Datos Profesores(Archivo JSON");
				profesor.MostrarDatosCVS();
				break;
			case '3':
				System.out.println("Modificar Datos Profesores");
				profesor.ModificarDatosCSV();
				break;
			case '4':
				System.out.println("Eliminar Profesores");
				profesor.EliminarDatoCSV();
				break;
			case '5':
				System.out.println("Saliendo............");
				default: System.out.println("Opcion Incorrecta, vuelve a intentarlo");break;
			}
		}while(OPC!='5');
	}
}
