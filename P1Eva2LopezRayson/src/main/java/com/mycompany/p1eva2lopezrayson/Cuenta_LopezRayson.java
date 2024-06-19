/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1eva2lopezrayson;

/**
 *
 * @author Rayson
 */
public class Cuenta_LopezRayson {
    double balance;
    public Cuenta_LopezRayson(double initialBalance){
        if(initialBalance>0.0){
            balance=initialBalance;
        }
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public void Ingresar(double mont){
        if(mont>0.0){
            balance=mont+balance;
        }
    }
     public void retirar(double monto) throws Exception {
        if (monto <= balance) {
            balance = balance - monto;
        } else {
            throw new Exception("Fondos insuficientes");
        }
    }  
     public double consultar() {
        return balance;
    }
}
