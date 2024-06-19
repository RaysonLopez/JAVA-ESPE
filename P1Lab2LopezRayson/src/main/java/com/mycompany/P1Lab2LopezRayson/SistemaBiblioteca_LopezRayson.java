package com.mycompany.P1Lab2LopezRayson;
import java.util.Scanner;
public class SistemaBiblioteca_LopezRayson extends Biblioteca_LopezRayson {
	public SistemaBiblioteca_LopezRayson() {
		super();
	}
	public void MenuPrincipal() {
		char OPC;
		long ISBNI = 0;
		String title,autor,ISBN = null,genero;
		String fecha;
		boolean prestado;
		Scanner scanner=new Scanner(System.in);
    	Biblioteca_LopezRayson sistema=new Biblioteca_LopezRayson();
		do {
		System.out.println("\n--- Biblioteca Loray ---");
        System.out.println("1. Agregar libro");
        System.out.println("2. Buscar libro por título");
        System.out.println("3. Pedir Libros");
        System.out.println("4. Mostrar Libros Prestados");
        System.out.println("5. Mostrar Historial Libros Disponibles");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");
        
        OPC=scanner.next().charAt(0);
        switch(OPC) {
        case '1': 
        	scanner.nextLine();
        	System.out.println("Opcion Agregar Libro");
        	System.out.println("Ingrese el titulo del libro");
        	title=scanner.nextLine();
        	System.out.println("Ingrese el autor del libro");
        	autor=scanner.nextLine();
        	System.out.println("Ingrese el genero del libro");
        	genero=scanner.nextLine();
        	System.out.println("Ingrese la fecha de ingreso");
        	fecha=FechaValidacion();
        	ISBNI=ValidacionISBN();
        	Libro_LopezRayson libro=new Libro_LopezRayson(title,autor,ISBNI,fecha,genero);
        	sistema.AgregarLibroAlCsv();
        	break;
        case '2':
        	
        	System.out.println("Opcion Buscar LIbro por Titulo");
        	title=scanner.nextLine();
        	sistema.BuscarLibro(title);
        	break;
        case '3':
        	scanner.nextLine();
        	System.out.println("Opcion Pedir Libros");
        	sistema.MostrarLibros();
        	System.out.println("Ingresa el titulo a pedir");
        	title=scanner.nextLine();
        	sistema.PedirLibro(title);
        	
        	break;
        case '4':
        	System.out.println("Opcion Mostrar Libros a CSV");
        	sistema.MostrarLibros();
        	break;
        case '5': 
        	System.out.println("Opcion Mostrar Historial Libros Prestados");
        	ExportarLibrosPedidosAJson();
        	break;
        case '6':
        	System.out.println("Opcion Mostrar Libros Disponibles");
        	ExportarLibrosDisponiblesAJson();
        case '7': 
        	System.out.println("Saliendo..........");
        	break;
        	default: System.out.println("Ingreso Incorrecto, ingresa nuevamente");
        }
		}while(OPC!='7');
		}
	
}