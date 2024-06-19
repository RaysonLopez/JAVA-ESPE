import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTareas {
    private static ArrayList<String> tareas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("Gestión de Lista de Tareas");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Marcar tarea como completa");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la tarea a agregar: ");
                    String tarea = scanner.nextLine();
                    agregarTarea(tarea);
                    break;
                case 2:
                    mostrarTareas();
                    break;
                case 3:
                    mostrarTareas();
                    System.out.print("Ingrese el número de tarea completada: ");
                    int numeroTarea = scanner.nextInt();
                    marcarTareaComoCompleta(numeroTarea);
                    break;
                case 4:
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

        System.out.println("Gracias por usar la Lista de Tareas.");
    }

    private static void agregarTarea(String tarea) {
        tareas.add(tarea);
        System.out.println("Tarea agregada con éxito.");
    }

    private static void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("La lista de tareas está vacía.");
        } else {
            System.out.println("Lista de Tareas:");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i));
            }
        }
    }

    private static void marcarTareaComoCompleta(int numeroTarea) {
        if (numeroTarea >= 1 && numeroTarea <= tareas.size()) {
            tareas.remove(numeroTarea - 1);
            System.out.println("Tarea marcada como completa.");
        } else {
            System.out.println("Número de tarea no válido.");
        }
    }
}
