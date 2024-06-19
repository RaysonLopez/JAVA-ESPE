/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.p1eva2lopezrayson;
import java.util.Scanner;
/**
 *
 * @author Rayson
 */
public class P1Eva2LopezRayson {

    public static void main(String[] args) {
        Cajero_LopezRayson cajero = new Cajero_LopezRayson(50.0);
        Scanner scanner = new Scanner(System.in);
        char OPC = '0';
        double mont;
        
        do {
            System.out.println("Ingresa la opcion");
            System.out.println("1. Ingreso");
            System.out.println("2. Retirar");
            System.out.println("3. Consultar");
            System.out.println("4. Salir");
            System.out.println("Elige la opcion");
            OPC = scanner.next().charAt(0);
            
            switch (OPC) {
                case '1' -> {
                    do {
                        System.out.println("Ingrese la cantidad a ingresar (entre 0 y 2500)");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Ingreso invalido, por favor ingrese un número válido:");
                            scanner.next(); // descartar entrada inválida
                        }
                        mont = scanner.nextDouble();
                    } while (mont < 0.0 || mont > 2500);
                    cajero.operacion("ingresar", mont); // Realizar la operación de ingreso
                }
                case '2' -> {
                    do {
                        System.out.println("Ingrese la cantidad a retirar (entre 0 y 500)");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Ingreso invalido, por favor ingrese un número válido:");
                            scanner.next(); // descartar entrada inválida
                        }
                        mont = scanner.nextDouble();
                    } while (mont < 0.0 || mont > 500);
                    cajero.operacion("retirar", mont); // Realizar la operación de retiro
                }
                case '3' -> {
                    // Consultar saldo
                    System.out.println("Saldo: " + cajero.consultar());
                }
                case '4' -> {
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                }
                default -> {
                    System.out.println("Opcion no valida");
                }
            }
        } while (OPC != '4');

        scanner.close();
    }
}
