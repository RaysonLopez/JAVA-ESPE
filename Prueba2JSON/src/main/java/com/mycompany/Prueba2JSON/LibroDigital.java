package com.mycompany.Prueba2JSON;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class LibroDigital extends Libro{
	String version;
	String extension;
	public LibroDigital(String titulo, String autor, long ISBN, String editorial,String version,String extension) {
		super(titulo, autor, ISBN, editorial);
		// TODO Auto-generated constructor stub
		this.version=version;
		this.extension=extension;
	}
	public void IngresarDatos() {
		super.IngresoDatos();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Ingresa la version del libro");
		this.version=scanner.nextLine();
		System.out.println("ingresa la extension del libro");
		this.version=scanner.nextLine();
	}

	@Override
	public void MostrarDatos() {
		super.MostrarDatos();
		System.out.println("Version: "+version+"Extension: "+extension);
	}
	public void DatosALJsonLibroDigital(LibroDigital libro) {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("titulo: ",libro.getTitulo());
		jsonObject.put("autor: ",libro.getAutor());
		try(FileWriter file=new FileWriter("archivosLibroD.json",true)){
			file.write(jsonObject.toJSONString());
			file.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void DatosALCSV(LibroDigital libro) {
		try(FileWriter file=new FileWriter("archivos.csv")){
			file.write("Libro: "+libro.titulo+",");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
    public void lectura csv main() {
        String csvFile = "example.csv";
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("Name: " + data[0] + ", Age: " + data[1] + ", Country: " + data[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
	public void leerArchivoJson(String nombreArchivo) {
        // Crear un objeto JSONParser
        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader(nombreArchivo)) {
            // Parsear el archivo JSON
            Object obj = jsonParser.parse(reader);
            
            // Convertir el objeto parseado en un JSONObject
            JSONObject jsonObject = (JSONObject) obj;
            
            // Obtener los valores del JSONObject
            String titulo = (String) jsonObject.get("titulo");
            String autor = (String) jsonObject.get("autor");
            long ISBN = (long) jsonObject.get("ISBN");
            String editorial = (String) jsonObject.get("editorial");
            String formato = (String) jsonObject.get("formato");
            double tamaño = (double) jsonObject.get("tamaño");

            // Imprimir los valores
            System.out.println("Título: " + titulo);
            System.out.println("Autor: " + autor);
            System.out.println("ISBN: " + ISBN);
            System.out.println("Editorial: " + editorial);
            System.out.println("Formato: " + formato);
            System.out.println("Tamaño: " + tamaño);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}