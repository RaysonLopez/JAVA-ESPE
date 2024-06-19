/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1eva2lopezrayson2;

/**
 *
 * @author Rayson
 */
public class Cuenta_LopezRayson {
    double saldo;
    public Cuenta_LopezRayson(double initialBalance){
        if(initialBalance>0.0){
            saldo=initialBalance;
        }
    }
    public double getSaldo(){
        return saldo;
    }
    public void setBalance(double saldo){
        this.saldo=saldo;
    }
    public void Ingresar(double monto){
        if(monto>0.0){
            monto=monto+saldo;
        }
    }
    public void retirar(double monto)throws Exception {
        if(monto<=saldo){
            monto= saldo-monto;
        }else{
            throw new Exception("Fondos insuficientes");
        }
    }
    double consultar(){
        return saldo;
    }
}
