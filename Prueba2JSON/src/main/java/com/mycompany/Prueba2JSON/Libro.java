package com.mycompany.Prueba2JSON;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
public class Libro {
	String titulo;
	String autor;
	long ISBN;
	String editorial;
	
	public Libro(String titulo,String autor,long ISBN,String editorial) {
		this.titulo=titulo;
		this.autor=autor;
		this.ISBN=ISBN;
		this.editorial=editorial;
	}
	public void MostrarDatos() {
		System.out.println("Titulo: "+titulo+" autor: "+autor+"ISBN: "+ISBN+"Editorial: "+editorial);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public void IngresoDatos() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Ingresa el titulo");
		this.titulo=scanner.nextLine();
		this.autor=scanner.nextLine();
		this.ISBN=scanner.nextLong();
		this.editorial=scanner.nextLine();

	}
	public void DatosAlJson(String libro,String autor,long ISBN,String editorial) {
		JSONObject jsonLibro=new JSONObject();
		jsonLibro.put("Autor: ", libro);
		jsonLibro.put("autor: ", autor);
		jsonLibro.put("ISBN: ", ISBN);
		jsonLibro.put("Editorial: ", editorial);
		try(FileWriter file= new FileWriter("archivos.json")) {
			file.write(jsonLibro.toJSONString());
			file.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
