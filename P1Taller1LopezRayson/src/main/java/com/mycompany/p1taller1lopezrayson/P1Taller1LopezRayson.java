package com.mycompany.p1taller1lopezrayson;
import java.util.Scanner;

public class P1Taller1LopezRayson {
    public static void main(String[] args) {
        char OPC = 0;
        Banco bank = new Banco();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Deposito");
            System.out.println("3. Retiro");
            System.out.println("4. Transferir");
            System.out.println("5. Consultar");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Ingresa el numero de cuenta ");
                    String accountNumber = scanner.nextLine();
                    while(!isNumeric(accountNumber)&&accountNumber.length()==11){
                        System.out.println("Vuelve a ingresar");
                        accountNumber=scanner.nextLine();
                                
                    }
                    System.out.print("Ingresa el tipo de cuenta ");
                    String typeAccount = scanner.nextLine();
                    System.out.println("1. Ahorros");
                    System.out.println("2. Corriente");
                    switch(OPC){
                        case '1' -> {
                            System.out.println("Haz seleccionado ahorros");
                            typeAccount="Ahorros";
                    }
                        case 2 -> {
                            System.out.println("haz elegido corriente");
                            typeAccount="Corriente";
                    }
                        default -> System.out.println("Opcion Invalida");
                    }
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    System.out.println("Ingresa la fecha del ingreso");
                    String date=scanner.nextLine();
                    Cuenta account = new Cuenta(accountNumber, initialBalance,date,typeAccount);
                    bank.addAccount(account);
                    System.out.println("Account created successfully.");
                }
                case 2 -> {
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposito(accountNumber, depositAmount);
                }
                case 3 -> {
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    bank.retiro(accountNumber, withdrawalAmount);
                }
                case 4 -> {
                    System.out.print("Enter source account number: ");
                    String fromAccountNumber = scanner.nextLine();
                    System.out.print("Enter destination account number: ");
                    String toAccountNumber = scanner.nextLine();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    bank.transfer(fromAccountNumber, toAccountNumber, transferAmount);
                }
                case 5 -> {
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    bank.displayAccountDetails(accountNumber);
                }
                case 6 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
        System.out.println("Thank you for using the banking system.");
    }
        public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}