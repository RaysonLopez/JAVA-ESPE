package com.mycompany.P1Taller3LopezRayson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Estudiante_LopezRayson extends Persona_LopezRayson{
	private String carrera;
	private String matricula;
	public Estudiante_LopezRayson(String name, String dateB, long CI,String carrera,String matricula) {
		super(name, dateB, CI);
		this.carrera=carrera;
		this.matricula=matricula;
	}
    @Override
    public void IngresarDatos() {
        super.IngresarDatos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar los datos de la carrera del estudiante");
        carrera = scanner.nextLine();
        System.out.println("Ingresa los datos de la matricula del estudiante");
        matricula = scanner.nextLine();
    }
	    @Override
	    public String toString() {
	        return "Estudiante: " + getName() + "\n" +
	               "Fecha de Nacimiento: " + getDateB() + "\n" +
	               "CI: " + getCI() + "\n" +
	               "Carrera: " + carrera + "\n" +
	               "Matricula Nro: " + matricula;
	    }
	    public void DatosAlJSON() {
	        JSONParser parser = new JSONParser();
	        JSONArray estudianteList;

	        // Leer el contenido existente del archivo JSON
	        try (FileReader reader = new FileReader("estudiante.json")) {
	            Object obj = parser.parse(reader);
	            if (obj instanceof JSONArray) {
	                estudianteList = (JSONArray) obj;
	            } else {
	                // Si el contenido no es un JSONArray, iniciar uno nuevo
	                estudianteList = new JSONArray();
	            }
	        } catch (IOException | ParseException e) {
	            // Si ocurre una excepción (archivo no existe o contenido no válido), iniciar un nuevo JSONArray
	            estudianteList = new JSONArray();
	        }

	        // Crear un nuevo objeto JSON para el estudiante
	        JSONObject estudianteDetails = new JSONObject();
	        estudianteDetails.put("name", getName());
	        estudianteDetails.put("dateB", getDateB());
	        estudianteDetails.put("CI", getCI());
	        estudianteDetails.put("carrera", carrera);
	        estudianteDetails.put("matricula", matricula);

	        // Agregar el nuevo objeto al JSONArray
	        estudianteList.add(estudianteDetails);

	        // Escribir el JSONArray completo al archivo JSON con formato
	        try (FileWriter file = new FileWriter("estudiante.json")) {
	            // Convertir JSONArray a String con saltos de línea
	            String jsonString = estudianteList.toJSONString().replace("},{", "},\n{");
	            file.write(jsonString);
	            file.flush();
	            System.out.println("Datos guardados en estudiante.json");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		 public void EliminarDatosJSON() {
		        java.io.File file = new java.io.File("estudiante.json");
		        if (file.delete()) {
		            System.out.println("Datos de estudiante eliminados.");
		        } else {
		            System.out.println("No se pudo eliminar el archivo.");
		        }
		    }

	    
		 public void MostrarDatosJSON() {
			    JSONParser parser = new JSONParser();

			    try (FileReader reader = new FileReader("estudiante.json")) {
			        // Leer el archivo JSON y convertirlo a un JSONArray
			        Object obj = parser.parse(reader);
			        if (obj instanceof JSONArray) {
			            JSONArray estudianteList = (JSONArray) obj;

			            // Iterar a través del JSONArray y mostrar los detalles de cada estudiante
			            for (Object estudianteObj : estudianteList) {
			                JSONObject estudianteDetails = (JSONObject) estudianteObj;
			                System.out.println("Estudiante: " + estudianteDetails.get("name"));
			                System.out.println("Fecha de Nacimiento: " + estudianteDetails.get("dateB"));
			                System.out.println("CI: " + estudianteDetails.get("CI"));
			                System.out.println("Carrera: " + estudianteDetails.get("carrera"));
			                System.out.println("Matricula Nro: " + estudianteDetails.get("matricula"));
			                System.out.println();
			            }
			        } else {
			            System.out.println("El archivo JSON no contiene un arreglo.");
			        }
			    } catch (IOException | ParseException e) {
			        e.printStackTrace();
			    }
			}
	    public void modificarDatosJSON() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Modificar los datos del estudiante:");
	        System.out.println("Nuevo nombre:");
	        setName(scanner.nextLine());
	        System.out.println("Nueva fecha de nacimiento:");
	        setDateB(scanner.nextLine());
	        System.out.println("Nuevo CI:");
	        setCI(scanner.nextLong());
	        scanner.nextLine(); // Clear the buffer
	        System.out.println("Nueva carrera:");
	        carrera = scanner.nextLine();
	        System.out.println("Nueva matricula:");
	        matricula = scanner.nextLine();

	        // Guardar los datos modificados
	        DatosAlJSON();
	    }
}
