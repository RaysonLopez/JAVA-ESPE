package com.mycompany.practicaparaprueba1;
import java.util.Scanner;

abstract class Persona {
    private String nombre;
    private String pin;

    public Persona(String nombre, String pin) {
        this.nombre = nombre;
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPin() {
        return pin;
    }
}

class Usuario extends Persona {
    private double saldo;

    public Usuario(String nombre, String pin, double saldo) {
        super(nombre, pin);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

class Sistema {
    private Usuario[] usuarios;

    public Sistema() {
        usuarios = new Usuario[]{
            new Usuario("Juan Perez", "1234", 1500.00),
            new Usuario("Maria Lopez", "5678", 2500.00)
        };
    }

    public Usuario validarPin(String pin) {
        for (Usuario usuario : usuarios) {
            if (usuario.getPin().equals(pin)) {
                return usuario;
            }
        }
        return null;
    }

    public double consultarSaldo(Usuario usuario) {
        return usuario.getSaldo();
    }

    public boolean realizarRetiro(Usuario usuario, double monto) {
        if (monto > 0 && monto <= usuario.getSaldo()) {
            usuario.setSaldo(usuario.getSaldo() - monto);
            return true;
        } else {
            return false;
        }
    }
}

class Cajero {
    private Sistema sistema;
    private Scanner scanner;

    public Cajero(Sistema sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.print("Ingrese su PIN (4 digitos): ");
        String pin = scanner.nextLine();

        Usuario usuario = sistema.validarPin(pin);

        if (usuario != null) {
            System.out.println("Bienvenido, " + usuario.getNombre());
            System.out.println("Su saldo actual es: " + usuario.getSaldo());
            mostrarMenu(usuario);
        } else {
            System.out.println("PIN incorrecto. Acceso denegado.");
        }
    }

    private void mostrarMenu(Usuario usuario) {
        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Realizar retiro");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    consultarSaldo(usuario);
                    break;
                case 2:
                    realizarRetiro(usuario);
                    break;
                case 3:
                    System.out.println("Gracias por usar el cajero automático. Hasta luego.");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (opcion != 3);
    }

    private void consultarSaldo(Usuario usuario) {
        double saldo = sistema.consultarSaldo(usuario);
        System.out.println("Su saldo actual es: " + saldo);
        pause();
    }

    private void realizarRetiro(Usuario usuario) {
        System.out.print("Ingrese el monto a retirar: ");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea

        if (sistema.realizarRetiro(usuario, monto)) {
            System.out.println("Retiro exitoso.");
            System.out.println("Factura:");
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Monto retirado: " + monto);
            System.out.println("Saldo restante: " + usuario.getSaldo());
        } else {
            System.out.println("Saldo insuficiente o monto inválido.");
        }
        pause();
    }

    private void pause() {
        System.out.println("\nPulse una tecla para continuar...");
        scanner.nextLine();
    }
}

public class BancoCajero {
    public static void main(String[] args) {
        Sistema Pedrososa = new Sistema();
        Cajero cajero = new Cajero(Pedrososa);
        cajero.iniciar();
    }
}
