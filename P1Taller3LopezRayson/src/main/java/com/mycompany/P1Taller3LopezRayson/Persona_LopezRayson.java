package com.mycompany.P1Taller3LopezRayson;

import java.util.Scanner;

public class Persona_LopezRayson {
	protected String name;
	private String dateB;
	private long CI;

	public Persona_LopezRayson(String name, String dateB, long CI) {
		this.name = name;
		this.dateB = dateB;
		this.CI = CI;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDateB() {
		return dateB;
	}


	public void setDateB(String dateB) {
		this.dateB = dateB;
	}


	public long getCI() {
		return CI;
	}


	public void setCI(long cI) {
		CI = cI;
	}


	public void IngresarDatos() {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Ingresa el nombre");
		this.name=scanner.nextLine();
		String ci;
		boolean validInput = false;
        do {
            System.out.println("Por favor, ingrese su ID (10 dígitos numéricos):");
            ci = scanner.nextLine();
            
            // Validar que la entrada tiene exactamente 10 dígitos numéricos
            if (ci.length() == 10 && ci.matches("\\d+")) {
                validInput = true;
            } else {
                System.out.println("Ingreso incorrecto, intente nuevamente.");
            }
        } while (!validInput);
        this.CI = Long.parseLong(ci);
        System.out.println("Ingrese la fecha de cumpleaños(dd/mm/yy)");
        this.dateB=scanner.nextLine();
	}
    public String toString() {
        return name + dateB + CI;
    }
	
}
