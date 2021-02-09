package fel;

import bll.models.entities.Address;
import bll.models.entities.Client;
import bll.models.entities.Manager;
import bll.models.services.ClientService;
import bll.models.services.ManagerService;
import dal.IDAO;
import dal.inmemory.ClientDAO;
import dal.inmemory.ManagerDAO;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Scanner;

public class App {
    private static final ManagerService managers = new ManagerService();
    private static final ClientService clients = new ClientService();
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        populate();

        int bureau = 12;
        System.out.printf("Voici les clients du manager au bureau %d : \n", bureau);
        managers.get(bureau).listClients();
        System.out.println("\n");

        System.out.println("Maintenant essayez de vous connecter en tant qu'un manager.");
        Manager m = null;
        int essaies = 0;
        while(m == null){
            essaies += 1;
            if(essaies > 1){
                System.out.println("Oops réessayez.\n\n");
            }
            System.out.println("Nom d'utilisateur (c'est 'username'):");
            String username = scanner.nextLine();
            System.out.println("Mot de passe (c'est 'password'):");
            String password = scanner.nextLine();
            m = managers.findAccountByLogin(username,password);
        }
        System.out.printf("Bravo %s %s, ça a pris %d essaies.\n",m.getFirstName(), m.getLastName(), essaies);

        double loan = 2680;
        double payment = 215;
        double interest = 4.6d;

        System.out.printf("Pret : %.2f, interet : %.2f, paiement : %.2f", loan, interest, payment);
        System.out.println("\n"+Client.paiementsV2(loan,interest,payment));

        clients.getAll().forEach(client -> {
            System.out.printf("Client id : %d, crédit est %s\n", client.getClientId(), clients.isApproved(client));
        });
        System.out.printf("Voici les clients et les stats du manager au bureau %d apres avoir échangé le plus riche et pauvre : \n", bureau);
        System.out.println(managers.get(bureau).organizeClients());
        managers.get(bureau).listClients();

        String cleartext = "anticonstitutionnellement";
        String key = "jeanguy";
        String encrypted = Manager.encrypt(cleartext,key);
        String decrypted = Manager.decrypt(encrypted, key);

        System.out.printf("""
                Texte clair : %s
                Clée : %s
                Texte encrypté : %s
                Text décrypté : %s
                """, cleartext, key, encrypted, decrypted);

    }

    private static void populate(){
        clients.create(new Client("Jean",
                "Guy",
                "4506781234",
                "courriel@gmail.com",
                "homme",
                new Address(124,"unerue","h1w6y8"),
                123456d,
                "marié",
                LocalDate.of(1978,1, 12),
                1234));
        clients.create(new Client("Charles",
                "Uber",
                "4506781234",
                "courriel@gmail.com",
                "homme",
                new Address(124,"unerue","h1w6y8"),
                95000d,
                "marié",
                LocalDate.of(1978,1, 12),
                1234));
        clients.create(new Client("Mark",
                "Zuck",
                "4506781234",
                "courriel@gmail.com",
                "homme",
                new Address(124,"unerue","h1w6y8"),
                234526d,
                "marié",
                LocalDate.of(1978,1, 12),
                1234));
        clients.create(new Client("Francois",
                "Legault",
                "4506781234",
                "courriel@gmail.com",
                "homme",
                new Address(124,"unerue","h1w6y8"),
                234000d,
                "marié",
                LocalDate.of(1978,1, 12),
                1234));
        clients.create(new Client("Valerie",
                "Laplante",
                "4506781234",
                "courriel@gmail.com",
                "femme",
                new Address(124,"unerue","h1w6y8"),
                123456d,
                "célibataire",
                LocalDate.of(1990,1, 12),
                1234));
        clients.create(new Client("Jeanne",
                "Mance",
                "4506781234",
                "courriel@gmail.com",
                "femme",
                new Address(124,"unerue","h1w6y8"),
                13d,
                "célibataire",
                LocalDate.of(1978,1, 12),
                1234));
        clients.create(new Client("Louis",
                "Loulou",
                "4506781234",
                "courriel@gmail.com",
                "homme",
                new Address(124,"unerue","h1w6y8"),
                1234d,
                "marié",
                LocalDate.of(1978,1, 12),
                1234));
        clients.create(new Client("Louis",
                "Loulou",
                "4506781234",
                "courriel@gmail.com",
                "homme",
                new Address(124,"unerue","h1w6y8"),
                1234d,
                "marié",
                LocalDate.of(2005,1, 12),
                1234));
        clients.create(new Client("Marie",
                "Robert",
                "4506781234",
                "courriel@gmail.com",
                "homme",
                new Address(124,"unerue","h1w6y8"),
                345987d,
                "marié",
                LocalDate.of(2000,1, 12),
                1234));
        managers.create(new Manager("Mike",
                "Wazowski",
                "5142345432",
                "manager@gmail.com",
                "homme",
                new Address(567, "larue", "j4r6t8"),
                12,
                clients.getAll().subList(0, 5),
                "password",
                "username"));
    }
}
