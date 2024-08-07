package com.mycompany.P1Lab2LopezRayson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Biblioteca_LopezRayson {
	private ArrayList<Libro_LopezRayson> libros;
	public Biblioteca_LopezRayson() {
		this.libros=new ArrayList<>();
	}
	public void AgregarLibroAlCsv() {
	    String archivoCSV = "Datos.csv"; // Cambia esto por la ruta de tu archivo CSV
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCSV, true))) {
	        for (Libro_LopezRayson libro : libros) {
	            writer.write("Libro: " + libro.getTitle() + "," + " Autor: " + libro.getAutor() + "," + " Genero: " + libro.getGenero() + "," + " ISBN: " + libro.getISBN() + "," + " Fecha: " + libro.getAnioPublicacion() + "," + "Estado: " + libro.isPrestado());
	            writer.newLine(); // Agrega un salto de línea al final de cada registro
	            System.out.println("Datos del libro agregados al archivo CSV.");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	    public void BuscarLibro(String title) {
	        String archivoCSV = "Datos.csv";
	        boolean encontrado = false;

	        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                // Verificar si la línea comienza con "Libro:"
	                    // Separar la línea en partes usando coma como delimitador
	                    String[] datos = linea.split(",");

	                    // Verificar que la línea tenga al menos 6 elementos
	                    if (datos.length >= 6) {
	                        String titulo = datos[0].substring(datos[0].indexOf(":") + 1).trim();
	                        String autor = datos[1].substring(datos[1].indexOf(":") + 1).trim();
	                        String genero = datos[2].substring(datos[2].indexOf(":") + 1).trim();
	                        String ISBN = datos[3].substring(datos[3].indexOf(":") + 1).trim();
	                        String fecha = datos[4].trim();  // Suponemos que la fecha no tiene etiqueta
	                        String estado = datos[5].substring(datos[5].indexOf(":") + 1).trim();

	                        // Depuración: imprimir los datos leídos
	                        System.out.println("Datos leídos:");
	                        for (String dato : datos) {
	                            System.out.println(dato);
	                        }

	                        if (titulo.equalsIgnoreCase(title)) {
	                            encontrado = true;
	                            System.out.println("Libro encontrado en el archivo CSV:");
	                            System.out.println("Título: " + titulo);
	                            System.out.println("Autor: " + autor);
	                            System.out.println("Género: " + genero);
	                            System.out.println("ISBN: " + ISBN);
	                            System.out.println("Fecha: " + fecha);
	                            System.out.println("Estado: " + estado);
	                            break; // Salimos del bucle al encontrar el libro
	                        }
	                    } else {
	                    	System.out.println("Línea malformada: " + linea);
	                    }
	                }
	            if (!encontrado) {
	                System.out.println("Libro no encontrado en el archivo CSV.");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		 public void MostrarLibros() {
		        String archivoCSV = "Datos.csv"; 
		        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
		            String linea;
		            System.out.println("Libros en el catálogo:");
		            while ((linea = br.readLine()) != null) {
		                String[] datos = linea.split(",");
		                if (datos.length == 6) {
		                    String title = datos[0];
		                    String autor = datos[1];
		                    String ISBN = datos[2];
		                    String fecha = datos[3];
		                    String genero = datos[4];
		                    String estado=datos[5];
		                    System.out.println(title + autor  + ISBN +  fecha +genero +estado);
		                }
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		 public void PedirLibro(String title) {
		        String archivoCSV = "Datos.csv"; // Cambia esto por la ruta de tu archivo CSV
		        String archivoTemp = "tempDB.csv"; // Archivo temporal para realizar cambios
		        boolean libroEncontrado = false;
		       
		        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
		             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemp))) {
		            String linea;
		            while ((linea = br.readLine()) != null) {
		                // Separar la línea en partes usando coma como delimitador
		                String[] datos = linea.split(",");

		                // Verificar que la línea tenga al menos 6 elementos
		                if (datos.length >= 6) {
		                    String titulo = datos[0].substring(datos[0].indexOf(":") + 1).trim();
		                    String autor = datos[1].substring(datos[1].indexOf(":") + 1).trim();
		                    String genero = datos[2].substring(datos[2].indexOf(":") + 1).trim();
		                    String ISBN = datos[3].substring(datos[3].indexOf(":") + 1).trim();
		                    String fecha = datos[4].trim();  // Suponemos que la fecha no tiene etiqueta
		                    String estado = datos[5].substring(datos[5].indexOf(":") + 1).trim();

		                    if (titulo.equalsIgnoreCase(title)) {
		                        libroEncontrado = true;
		                        System.out.println("Libro encontrado y pedido:");
		                        System.out.println("Título: " + titulo);
		                        System.out.println("Autor: " + autor);
		                        System.out.println("Género: " + genero);
		                        System.out.println("ISBN: " + ISBN);
		                        System.out.println("Fecha: " + fecha);
		                        System.out.println("Estado: " + estado);

		                        // Cambiar el estado a 'true'
		                        datos[5] = "Estado: true";

		                        // Escribir la línea modificada en el archivo temporal
		                        writer.write(String.join(",", datos) + "\n");
		                    } else {
		                        // Escribir la línea sin modificar en el archivo temporal
		                        writer.write(linea + "\n");
		                    }
		                } else {
		                    System.out.println("Línea malformada: " + linea);
		                    // Escribir la línea sin modificar en el archivo temporal
		                    writer.write(linea + "\n");
		                }
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        // Reemplazar el archivo original con el archivo temporal
		        if (libroEncontrado) {
		            File archivoOriginal = new File(archivoCSV);
		            File archivoTemporal = new File(archivoTemp);
		            if (archivoOriginal.delete()) {
		                archivoTemporal.renameTo(archivoOriginal);
		                System.out.println("El archivo ha sido actualizado.");
		            } else {
		                System.out.println("No se pudo actualizar el archivo.");
		            }
		        } else {
		            System.out.println("El libro con el título '" + title + "' no fue encontrado en el catálogo.");
		            // Eliminar el archivo temporal si no se encontró el libro
		            new File(archivoTemp).delete();
		        }
		 }
	 public long ValidacionISBN() {
			long ISBNI = 0;
			Scanner scanner=new Scanner(System.in);
	   	 	String ISBN;
		while (true) {
	         System.out.print("Ingrese el ISBN (13 dígitos): ");
	         ISBN = scanner.next();
	         // Validar que la entrada contiene solo dígitos y tiene 13 caracteres
	         if (ISBN.matches("\\d{13}")) {
	             break; // Salir del bucle si la entrada es válida
	         } else {
	             System.out.println("Ingreso invalido, intente nuevamente.");
	         }
	     }
	     try {
	         ISBNI = Long.parseLong(ISBN);
	         System.out.println("ISBN válido: " + ISBNI);
	     } catch (NumberFormatException e) {
	         System.out.println("Error al convertir el ISBN a número.");
	     }
		return ISBNI;
		}
		public String FechaValidacion() {
		      Scanner scanner = new Scanner(System.in);
		        String fecha;
		        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        while (true) {
	            System.out.print("Ingrese una fecha (dd/MM/yyyy): ");
	            fecha = scanner.next();

	            try {
	                LocalDate.parse(fecha, dtf);
	                System.out.println("Fecha válida: " + fecha);
	                break; // Salir del bucle si la fecha es válida
	            } catch (DateTimeParseException e) {
	                System.out.println("Fecha invalida, intente nuevamente.");
	            }
	        }
	        return fecha;
		}
	    public List<Libro_LopezRayson> BuscarLibrosPrestados() {
	        List<Libro_LopezRayson> librosPrestados = new ArrayList<>();
	        String archivoCSV = "Datos.csv";

	        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                String[] datos = linea.split(",");
	                if (datos.length == 6 && datos[5].equals("true")) {
	                    Libro_LopezRayson libro = new Libro_LopezRayson(
	                        datos[0], datos[1], Long.parseLong(datos[2]), datos[3], datos[4]
	                    );
	                    libro.setPrestado(true);
	                    librosPrestados.add(libro);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return librosPrestados;
	    }

	    public List<Libro_LopezRayson> BuscarLibrosDisponibles() {
	        List<Libro_LopezRayson> librosDisponibles = new ArrayList<>();
	        String archivoCSV = "Datos.csv";

	        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                String[] datos = linea.split(",");
	                if (datos.length == 6 && datos[5].trim().equalsIgnoreCase("Estado: true")) {
	                    Libro_LopezRayson libro = new Libro_LopezRayson(
	                        datos[0].substring(datos[0].indexOf(":") + 1).trim(),
	                        datos[1].substring(datos[1].indexOf(":") + 1).trim(),
	                        Long.parseLong(datos[3].substring(datos[3].indexOf(":") + 1).trim()),
	                        datos[4].trim(), 
	                        datos[2].substring(datos[2].indexOf(":") + 1).trim()
	                    );
	                    libro.setPrestado(false);
	                    librosDisponibles.add(libro);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return librosDisponibles;
	    }
	    public void ExportarLibrosPedidosAJson() {
	        List<Libro_LopezRayson> librosDisponibles = BuscarLibrosDisponibles();
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String json = gson.toJson(librosDisponibles);

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("LibrosPedidos.json"))) {
	            writer.write(json);
	            System.out.println("Libros disponibles exportados a LibrosDisponibles.json");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public void ExportarLibrosDisponiblesAJson() {
	        List<Libro_LopezRayson> librosDisponibles = BuscarLibrosDisponibles();
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String json = gson.toJson(librosDisponibles);

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("LibrosPedidos.json"))) {
	            writer.write(json);
	            System.out.println("Libros disponibles exportados a LibrosDisponibles.json");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	        	System.out.println("Codigo ejeecutado correctamente, sin errores.");
	        }
	    }
	} 