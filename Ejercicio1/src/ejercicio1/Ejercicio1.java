package ejercicio1;

import javax.swing.JOptionPane;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        Cuadrilatero cl;
        float lado1,lado2;
        lado1=Float.parseFloat(JOptionPane.showInputDialog("Digita el lado1"));
        lado2=Float.parseFloat(JOptionPane.showInputDialog("Digita el lado 2"));
        if(lado1==lado2){
            cl=new Cuadrilatero(lado1);
        }else{
            cl=new Cuadrilatero(lado1,lado2);
        }
    } 
        
    }
    
