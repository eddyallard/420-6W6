package bll.models.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
@Data
public class Manager extends User {
    private int officeNumber;
    private String username;
    private String password;
    private List<Client> clients;

    public Manager(String firstName, String lastName, String phoneNumber, String email, String sex, Address mainAddress, int officeNumber, List<Client> clients, String password, String username) {
        super(firstName, lastName, phoneNumber, email, sex, mainAddress);
        this.officeNumber = officeNumber;
        if(clients.size() != 5)
            try {
                throw new Exception("Le gestionnaire doit avoir 5 clients.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        else
            this.clients = clients;
        this.username = username;
        this.password = password;
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public void listClients(){
        clients.stream()
                .map(Client::toString)
                .forEach(System.out::println);
    }

    public double viewAccountBalance(int accountNumber, int clientId){
        Client client = clients.stream()
                .filter(c -> c.getClientId() == clientId)
                .findFirst()
                .orElse(null);
        try {
            return client.viewBalance(accountNumber);
        } catch (NullPointerException e){
            throw new Error(String.format("Vous ne possédez aucun client avec l'id %d",clientId));
        }
    }

    public double withdraw(int accountNumber, int clientId, double amount){
        Client client = clients.stream()
                .filter(c -> c.getClientId() == clientId)
                .findFirst()
                .orElse(null);
        try {
            return client.withdraw(accountNumber, amount);
        } catch (NullPointerException e){
            throw new Error(String.format("Vous ne possédez aucun client avec l'id %d",clientId));
        }
    }

    public double deposit(int accountNumber, int clientId, double amount){
        Client client = clients.stream()
                .filter(c -> c.getClientId() == clientId)
                .findFirst()
                .orElse(null);
        try {
            return client.deposit(accountNumber, amount);
        } catch (NullPointerException e){
            throw new Error(String.format("Vous ne possédez aucun client avec l'id %d",clientId));
        }
    }

    public void openAccount(int clientId, String accountType){
        Client client = clients.stream()
                .filter(c -> c.getClientId() == clientId)
                .findFirst()
                .orElse(null);
        try {
            client.openAccount(accountType, 0.0d);
        } catch (NullPointerException e){
            throw new Error(String.format("Vous ne possédez aucun client avec l'id %d",clientId));
        }
    }

    public void addCredit(int clientId, double amount){
        //Méthode pas implémentée car dans le contexte de cette exercice c'est la même chose que deposit().
        throw new UnsupportedOperationException();
    }

    public String organizeClients(){
        Client topEarner = null;
        Client bottomEarner = null;
        double average = 0d;

        for (Client client : clients) {
            average += client.getIncome();
            if (topEarner == null){
                topEarner = client;
                bottomEarner = client;
            }
            else{
                if (client.getIncome() > topEarner.getIncome())
                    topEarner = client;
                if (client.getIncome() <= bottomEarner.getIncome())
                    bottomEarner = client;
                average /= 2;
            }
        }

        int topIndex = clients.indexOf(topEarner);
        int bottomIndex = clients.indexOf(bottomEarner);

        clients.set(topIndex, bottomEarner);
        clients.set(bottomIndex, topEarner);

        return String.format("""
                        
                        Top earner : %s %s avec %.2f$
                        Bottom earner : %s %s avec %.2f$
                        Différence : %.2f
                        Moyenne : %.2f
                        """
                ,topEarner.getFirstName(), topEarner.getLastName(), topEarner.getIncome()
                ,bottomEarner.getFirstName(), bottomEarner.getLastName(), bottomEarner.getIncome()
                ,topEarner.getIncome()-bottomEarner.getIncome(), average);

    }

    public static String encrypt(String cleartext, String key){
        //Je vais encrypter en assumant que tous les text/clée est en minuscule. Je fais seulement viginère car c'est le plus compliqué.
        int buffer = 97; //Valeur de 'a' en ascii.
        StringBuilder encrypted = new StringBuilder();
        for(int i=0; i<cleartext.length(); i++){
            int cleartext_code = ((int) cleartext.charAt(i)) - buffer;
            int key_code = ((int) key.charAt(i % key.length()))-buffer;
            encrypted.append((char)(((cleartext_code + key_code)%26)+buffer));
        }
        return encrypted.toString();
    }

    public static String decrypt(String encrypted, String key){
        int buffer = 97;
        StringBuilder decrypted = new StringBuilder();
        for(int i=0; i<encrypted.length(); i++){
            int encrypted_code = encrypted.charAt(i);
            int key_code = key.charAt(i % key.length());
            if (encrypted_code<key_code){
                encrypted_code+=26;
            }
            decrypted.append((char)(((encrypted_code - key_code)%26)+buffer));
        }
        return decrypted.toString();
    }
}
