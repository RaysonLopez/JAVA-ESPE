import javax.swing.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int arreglo[],nELementos,aux;
        nELementos= Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de numeros a ingresar: "));
        arreglo=new int[nELementos];
        for (int i=0;i<nELementos;i++){
            System.out.println((i+1)+"Digite un numero: ");
            arreglo[i]=entrada.nextInt();
        }
        for (int i=0;i<(nELementos-1);i++){
            for(int j=0;j<(nELementos-1);j++){
                if(arreglo[j]>arreglo[j+1]){
                    aux=arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=aux;
                }
            }
        }
        for(int i=0;i<nELementos;i++){
            System.out.println("Numeros ordenados de mayor a menor \n"+arreglo[i]);
        }
        }

}