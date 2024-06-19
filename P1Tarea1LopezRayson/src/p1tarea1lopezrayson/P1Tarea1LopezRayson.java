package p1tarea1lopezrayson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
public class P1Tarea1LopezRayson {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        int nTask,opc,indexToRemove,index=0;
        String[]task=null;
        do{ 
        System.out.println("Gestor de Tareas(To Do List\nIngrese su opcion(1-5)");
        System.out.println("1. Ingresar Tareas");
        System.out.println("2. Leer Tareas Pendientes");
        System.out.println("3. Marcar Tarea como completada");
        System.out.println("4. Guardar Tareas en Archivo ");
        System.out.println("5. Salir");
        
        while(!scanner.hasNextInt()){
            System.out.println("Ingreso invalido, intenta nuevamente");
            scanner.next();
        }
        opc=scanner.nextInt();
        switch(opc){
            case 1 -> { 
            
            System.out.println("Ingresa el número de tareas a ingresar:");
            while (!scanner.hasNextInt()) {
            System.out.println("Ingreso mal colocado, intenta nuevamente");
                scanner.next(); // Descartar el token no válido
             }
             nTask = scanner.nextInt();
             task=new String[nTask];
             scanner.nextLine();
             for(int i=index;i<nTask;i++){
                 System.out.println("Ingresa la tarea pendiente ["+(i+1)+"].");
                 task[i]=scanner.nextLine();
                 index++;
             }
            }    
            case 2 -> {
                if(task==null || task.length == 0){
                    System.out.println("No se ha ingresado ninguna tarea");
                    return;
                }
                System.out.println("Leyendo tareas pendientes.......");
                    for (int i = 0; i < task.length; i++) {
                    System.out.println("Tarea encontrada [" + (i + 1) + "]: " + task[i]);
                }
                
            }
            case 3 -> {
                                if(task==null || task.length == 0){
                    System.out.println("No se ha ingresado ninguna tarea");
                    return;
                }
            System.out.println("Leyendo tareas pendientes.......");
                    for (int i = 0; i < task.length; i++) {
                    System.out.println("Tarea encontrada [" + (i + 1) + "]: " + task[i]);
                }
                System.out.println("");
                System.out.println("Que tarea desea marcar como completada(Solo numeros)");
                while(!scanner.hasNextInt()){
                    System.out.println("Ingreso invalido, intenta nuevamente");
                }
            indexToRemove=scanner.nextInt()-1 ;

            // Crear un nuevo arreglo sin la tarea en el índice 2
            String[] newTaskArray = new String[task.length - 1];
            System.arraycopy(task, 0, newTaskArray, 0, indexToRemove);
            System.arraycopy(task, indexToRemove + 1, newTaskArray, indexToRemove, task.length - indexToRemove - 1);

            // Actualizar el arreglo original con el nuevo arreglo
            task = newTaskArray;
            // Actualizar el arreglo original con el nuevo arreglo
            task = newTaskArray;
            }
            case 4 -> {
            File archivo = new File("Tareas.txt");
            try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            FileWriter writer = new FileWriter(archivo);
            BufferedWriter archivoE = new BufferedWriter(writer);

            for (int i = 0; i < task.length; i++) {
                archivoE.write("Tareas Ingresadas: " + task[i] + "\n");
            }

            archivoE.close();

            System.out.println("Tareas escritas en el archivo correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
            case 5 -> System.out.println("Gracias por utilizar mi programa,vuelve pronto");
            default -> System.out.println("Ingreso mal colocado, intentalo de nuevo (1-5)");
}  
        }while(opc!=5);
        }
    }
   
