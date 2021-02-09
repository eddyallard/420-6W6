package bll.models.entities;

import lombok.Data;

@Data
public class Account {
    private static int AUTO_ACCOUNT_NUMBER = 0;
    private final int accountNumber;
    private String type;
    private double balance;
    private Client owner;

    public Account(String type, double initialDeposit, Client owner) {
        this.accountNumber = AUTO_ACCOUNT_NUMBER++;
        this.type = type;
        this.balance = initialDeposit;
        this.owner = owner;
    }

    //Méthode pas dans le schéma, mais elle me sauve quelques lignes de code.
    public double updateBalance(double adjustment){
        this.balance += adjustment;
        return this.balance;
    }
}
