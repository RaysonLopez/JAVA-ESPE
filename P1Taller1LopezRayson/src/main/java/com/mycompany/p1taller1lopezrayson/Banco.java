/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1taller1lopezrayson;
import java.util.HashMap;
import java.util.Map;
public class Banco {
        private Map<String, Cuenta> accounts;

    public Banco() {
        accounts = new HashMap<>();
    }

    public void addAccount(Cuenta account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Cuenta getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void deposito(String accountNumber, double amount) {
        Cuenta account = getAccount(accountNumber);
        if (account != null) {
            account.deposito(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void retiro(String accountNumber, double amount) {
        Cuenta account = getAccount(accountNumber);
        if (account != null) {
            account.retiro(amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Cuenta fromAccount = getAccount(fromAccountNumber);
        Cuenta toAccount = getAccount(toAccountNumber);
        if (fromAccount != null && toAccount != null && fromAccount.getbalance() >= amount) {
            fromAccount.retiro(amount);
            toAccount.deposito(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed.");
        }
    }

    public void displayAccountDetails(String accountNumber) {
        Cuenta account = getAccount(accountNumber);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account not found.");
        }
    }
}
