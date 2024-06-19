/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1eva2lopezrayson2;

/**
 *
 * @author Rayson
 */
public class Cajero_LopezRayson extends Cuenta_LopezRayson {
    char OPC;
    public Cajero_LopezRayson(double saldo){
        super(saldo);
    }
    public void operacion(String tipo,double monto){
        try{
            if (tipo.equalsIgnoreCase("ingresar")) {
                Ingresar(monto);
            } else if (tipo.equalsIgnoreCase("retirar")) {
                retirar(monto);
            } else {
                throw new Exception("Operación no válida");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
