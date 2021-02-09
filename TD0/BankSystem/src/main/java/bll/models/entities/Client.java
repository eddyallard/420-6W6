package bll.models.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
@Data
public class Client extends User {
    private static int AUTO_CLIENT_ID = 0;
    private final int clientId;
    private double income;
    private String maritalStatus;
    private LocalDate birthDate;
    private int nip;
    private List<Account> accounts;

    public Client(String firstName, String lastName, String phoneNumber, String email, String sex, Address mainAddress, double income, String maritalStatus, LocalDate birthDate, int nip) {
        super(firstName, lastName, phoneNumber, email, sex, mainAddress);
        this.clientId = AUTO_CLIENT_ID++;
        this.income = income;
        this.maritalStatus = maritalStatus;
        this.birthDate = birthDate;
        this.nip = nip;
    }

    public void openAccount(String accountType, double initialDeposit){
        accounts.add(new Account(accountType, initialDeposit, this));
    };

    public double deposit(int accountNumber, double amount){
        Account account = accounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);
        try {
            return account.updateBalance(amount);
        } catch (NullPointerException e){
            throw new Error(String.format("Vous ne possédez aucun compte avec l'id %d", accountNumber));
        }
    }

    public double withdraw(int accountNumber, double amount){
        Account account = accounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);
        try {
            return account.updateBalance(-1*amount);
        } catch (NullPointerException e){
            throw new Error(String.format("Vous ne possédez aucun compte avec l'id %d", accountNumber));
        }
    }

    public double viewBalance(int accountNumber){
        Account account = accounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);
        try {
            return account.getBalance();
        } catch (NullPointerException e){
            throw new Error(String.format("Vous ne possédez aucun compte avec l'id %d", accountNumber));
        }
    }

    public List<String> viewHistory(int accountNumber){
        throw new UnsupportedOperationException();
    }

    public String paiementsV1(double loan, double interest, double payment){
        throw new UnsupportedOperationException(); //Je ne connais pas la formule et je ne l'ai pas trouvé.
    }

    public static String paiementsV2(double loan, double interest, double payment){
        int months = 0;
        double lastPayment = 0d;
        double totalReimbursed = 0d;
        while (loan > 0){
            if(loan >= payment) {
                loan *= (1 + interest / (100 * 12)); //A la fin de chaque mois, l'interet s'ajoute.
                loan -= payment;    //Paiement a chaque mois d'un montant x
                totalReimbursed += payment;
            }else{
                lastPayment = loan*(1+interest/(100*12)); //On met l'interet sur le dernier mois avant le paiement
                loan -= lastPayment; //paiement de la balance
                totalReimbursed += lastPayment;
            }
            months+=1;
        }
        if (lastPayment != 0){
            return String.format("Le dernier paiement était de %.2f et tout les paiements se sont éxécutés en %d an et %d mois, pour un total de %.2f", lastPayment, (months-months%12)/12, months%12, totalReimbursed);
        }
        return String.format("Les paiements se sont éxécutés en %d an et %d mois, pour un total de %.2f", (months-months%12)/12, months%12, totalReimbursed);
    }

    public int getAge(){
        LocalDate now = LocalDate.now();
        int age = now.getYear() - birthDate.getYear();
        if (now.getDayOfYear()<=birthDate.getDayOfYear()){
            age+=1;
        }
        return age;
    }
}
