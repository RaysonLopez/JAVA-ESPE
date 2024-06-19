package com.mycompany.P1Taller3LopezRayson;

import java.util.Scanner;
import java.io.*;
public class Profesor_LopezRayson extends Persona_LopezRayson {
	protected double salario;
	protected int cargaH;
	
	public Profesor_LopezRayson(String name, String dateB, long CI,double salario,int cargaH) {
		super(name, dateB, CI);
		this.salario=salario;
		this.cargaH=cargaH;
	}
	public void IngresarDatos() {
		Scanner scanner=new Scanner(System.in);
		super.IngresarDatos();
		System.out.println("Ingrese los datos del salario");
		salario=scanner.nextDouble();
		System.out.println("Ingrese la carga horaria");
		cargaH=scanner.nextInt();
	}
	   public void MostrarDatosCVS() {
	        try (BufferedReader br = new BufferedReader(new FileReader("profesor.csv"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
    public void DatosAlCSV() {
        try (FileWriter fileWriter = new FileWriter("profesor.csv", true); 
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.printf("%s,%s,%d,%.2f,%d%n", getName(), getDateB(), getCI(), salario, cargaH);
            System.out.println("Datos guardados en profesor.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void EliminarDatoCSV() {
        File inputFile = new File("profesor.csv");
        File tempFile = new File("profesor_temp.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {
            String line;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el CI del profesor a eliminar:");
            long ciToDelete = scanner.nextLong();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                long ci = Long.parseLong(data[2]);
                if (ci != ciToDelete) {
                    pw.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!inputFile.delete()) {
            System.out.println("No se pudo eliminar el archivo original");
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("No se pudo renombrar el archivo temporal");
        }
    }

    public void ModificarDatosCSV() {
        File inputFile = new File("profesor.csv");
        File tempFile = new File("profesor_temp.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {
            String line;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el CI del profesor a modificar:");
            long ciToModify = scanner.nextLong();
            scanner.nextLine(); // Clear the buffer

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                long ci = Long.parseLong(data[2]);

                if (ci == ciToModify) {
                    System.out.println("Ingrese el nuevo nombre:");
                    String newName = scanner.nextLine();
                    System.out.println("Ingrese la nueva fecha de nacimiento:");
                    String newDateB = scanner.nextLine();
                    System.out.println("Ingrese el nuevo salario:");
                    double newSalario = scanner.nextDouble();
                    System.out.println("Ingrese la nueva carga horaria:");
                    int newCargaH = scanner.nextInt();
                    pw.printf("%s,%s,%d,%.2f,%d%n", newName, newDateB, ciToModify, newSalario, newCargaH);
                } else {
                    pw.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!inputFile.delete()) {
            System.out.println("No se pudo eliminar el archivo original");
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("No se pudo renombrar el archivo temporal");
        }
    }
}
