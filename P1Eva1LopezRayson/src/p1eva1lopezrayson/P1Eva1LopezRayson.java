package p1eva1lopezrayson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
---------------------------------------------------
           UNIVERSIDAD DE LAS FUERZAS ARMADAS
                  Carrera de Ingeniería
              NRC: 15279 - Programación Orientada a Objetos
---------------------------------------------------
                       Rayson López
 */
//camelCase para variables
//PascalCase para clases
public class P1Eva1LopezRayson {
    public static void main(String[] args) throws IOException {
        List<Double> valores = new ArrayList<>();
        String[] Clientes = null; 
        Scanner scanner=new Scanner(System.in);

        char opc;
        
        
        do{
        System.out.println("Ingresa tus opciones");   
        System.out.println("1. Calculadora del IVA");
        System.out.println("2. Ingreso Clientes");
        System.out.println("3. Guardar Datos");
        System.out.println("4. Salir");
        opc = scanner.next().charAt(0);
        while (!(opc >= '0' && opc <= '9')){
            System.out.println("tu ingreso no es valido");
            scanner.next();
            opc = scanner.next().charAt(0);
        }
        
        switch(opc){
            case '1' -> { 
                   valores=OPC1();
                }
            case '2' -> {
                    Clientes=OPC2();
                }
            case '3'->{
                GuardarArchivo(Clientes,valores);
            }
            case '4'->{
                System.out.println("Gracias por utilizar mi programa, Vuelva pronto");
            }
            default -> System.out.println("Tu ingreso no es valido");
        }
        }while(opc!='4');
    }
    public static List<Double> OPC1(){
        Scanner scanner=new Scanner(System.in);
        int product;
        double value,IVA=0.15,total,totalS;
        do {
            System.out.println("Ingresa la cantidad a comprar");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Ingresa un número entero:");
                scanner.next(); // Descarta la entrada no válida    
            }
            product = scanner.nextInt();
        } while (product < 0||product >1000); 

            do{
            System.out.println("Ingresa el precio de los productos");
            while (!scanner.hasNextDouble()) {
                System.out.println("Entrada no válida. Ingresa un número entero:");
                scanner.next(); // Descarta la entrada no válida 
            }
            value = scanner.nextDouble();
            }while(value<0||value>1000);
            
                total=(product*value)*IVA+(product*value);
                totalS=(product*value);
                System.out.println("El producto con IVA es: "+total);
                System.out.println("El producto sin IVA es: "+totalS);
                List<Double> valores = new ArrayList<>();
                valores.add((double) product);
                valores.add(value);
                valores.add(total);
                valores.add(totalS);
                return valores;
    }
    public static String[]OPC2(){
        Scanner scanner=new Scanner(System.in);
            int n = 0;
            String []Clientes = null;
                        do{
                System.out.println("Ingresa la cantidad de gente que ingresaras");
                while(!scanner.hasNextInt()){
                    System.out.println("Ingreso mal colocado");
                    scanner.next();
                }
                n=scanner.nextInt();
                }while(n<=0);
                Clientes=new String[n];
                scanner.nextLine();
                for(int i=0;i<n;i++){
                    System.out.println("Ingresa el nombre del cliente nro: "+(i+1));
                    Clientes[i]=scanner.nextLine();
                }
                burbuja(Clientes);
                System.out.println("Arreglo ordenado: ");
            for (String num : Clientes) {
                System.out.println(num + " ");
                }
            return Clientes;
    }
    public static void GuardarArchivo(String[]matrix,List<Double> valores) throws IOException{
                File archivo=new File("Datos.txt");
                FileWriter writer = new FileWriter(archivo);
                BufferedWriter archivoE = new BufferedWriter(writer);
                  if(matrix == null || matrix.length == 0){
                    System.out.println("No se ha ingresado datos en el arreglo");
                }
                if (valores.isEmpty()) {
                System.out.println("La lista está vacía. Cerrando el programa.");
                return;
                }
                try{
                    if(!archivo.exists()){
                        archivo.createNewFile();
                        
                    }
                    archivoE.write("{Cantidad a comprar: " + valores.get(0));
                    archivoE.write(" Precio de los productos: " + valores.get(1) + "}");
                    archivoE.write("Producto con IVA: " + valores.get(2));
                    archivoE.write("Producto sin IVA: " + valores.get(3) + "}\n");
                    archivoE.write("{");
  if (matrix != null) {
            for (String Cliente : matrix) {
                archivoE.write(" Nombre Ingresado: " + Cliente);
            }
            archivoE.write("}");
        } else {
            System.out.println("Los datos de CLIENTES esta incompleto");
        }
                    
                    archivoE.close();
            System.out.println("Datos guardados correctamente en datos.txt");
                    
                }catch(IOException e){
                   e.printStackTrace(System.out);
                }
    }
    public static void burbuja(String[]matrix){
        String temp;
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix.length-1;j++){
                if (matrix[j].compareTo(matrix[j + 1]) > 0){
                    temp=matrix[j];
                    matrix[j]=matrix[j+1];
                    matrix[j+1]=temp;
                          
                }
            }
        }
    }
}
   
