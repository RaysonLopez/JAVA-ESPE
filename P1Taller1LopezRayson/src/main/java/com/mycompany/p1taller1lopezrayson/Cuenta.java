/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1taller1lopezrayson;

/**
 *
 * @author Rayson
 */
public class Cuenta {   
    String accountNumber;
    double balance;
    String typeAccount;
    String date;
    
    public Cuenta(String accountNumber,double initialBalance,String typeAccount,String date){
        this.accountNumber=accountNumber;
        this.balance=initialBalance;
        this.date=date;
        this.typeAccount=typeAccount;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public double getbalance(){
    return balance;
    }
    public String gettypeAccount(){
        return typeAccount;
    }
    
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", Tipo De Cuenta=" + typeAccount + '\'' +
                ", balance=" + balance +
                '}';
    }
    public void deposito(double amount){
        if(amount>0||amount<2500){
            balance+=amount;
            
        }else{
            System.out.println("Cantidad de deposito invalida");
        }
    }
    public void retiro(double amount){
        if(amount > 0 && amount<=balance || amount<500){
            balance-=amount;
        }else{
            System.out.println("Ingreso de deposito invalido");
        }
    }
}
