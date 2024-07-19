/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Rayson
 */
public class Model {
    private int num1,num2;
    private double calcular;
    public Model(){
        
    }

    public Model(int num1, int num2, int calcular) {
        this.num1 = num1;
        this.num2 = num2;
        this.calcular = calcular;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public double getCalcular() {
        return calcular;
    }

    public void setCalcular(double calcular) {
        this.calcular = calcular;
    }
    public int sumar(){
        return num1+num2;
    }
    public int restar(){
        return num1-num2;
    }
    public int multiplicar(){
        return num1*num2;
    }
    public double dividir(){
        return num1/num2;
    }
}
