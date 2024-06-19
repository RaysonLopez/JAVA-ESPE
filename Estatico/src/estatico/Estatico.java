/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estatico;

/**
 *
 * @author Rayson
 */
public class Estatico {
    public static String frase="Primera Frase";
    public static int sumar(int n1,int n2){
        int suma=n1+n2;
        return suma;
    }
    public static void main (String [] args){
        System.out.println(Estatico.frase);
        System.out.println("La suma es: "+ Estatico.sumar(3,4));
    }
    
}
