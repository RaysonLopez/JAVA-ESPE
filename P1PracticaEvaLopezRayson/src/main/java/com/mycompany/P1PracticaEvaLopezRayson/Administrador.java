package com.mycompany.P1PracticaEvaLopezRayson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Administrador extends Persona{
	private ArrayList<Administrador>admin;
	private String credentials;
	public Administrador(String nombres,String apellidos,String telf,String CI) {
		super(nombres,apellidos,telf,CI);
		this.admin=new ArrayList<>();
	}
	@Override
	public void IngresarDatos() {
		Scanner scanner=new Scanner(System.in);
		super.IngresarDatos();
		System.out.println("Ingresa las credenciales");
		this.credentials=scanner.nextLine();
		this.admin.add(this);
	}

	public void DatosCSV() {
		try(FileWriter file=new FileWriter("archivos.csv",true)){
			for(Administrador admin:this.admin) {
			file.write("Nombres: "+getNombres()+","+"Apellidos: "+getApellidos()+","+"Telefono: "+getTelf()+","+"Cedula: "+getCI()+","+credentials);
			
		}
			file.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void MostrarDatosCSV() {
		String archivoCSV="archivos.csv";
		try(BufferedReader br=new BufferedReader(new FileReader(archivoCSV))){
			String linea;
			System.out.println("Datos en el archivo CSV");
			while((linea=br.readLine())!=null) {
				String[]datos=linea.split(",");
				for(String dato:datos) {
					System.out.println(dato.trim());
				}
			}
				System.out.println("------------");
			}catch(IOException e){
				e.printStackTrace();
			}
	}
}