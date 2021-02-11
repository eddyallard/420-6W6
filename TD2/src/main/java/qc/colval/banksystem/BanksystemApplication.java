package qc.colval.banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import qc.colval.banksystem.entities.*;
import qc.colval.banksystem.entities.enums.AccountType;
import qc.colval.banksystem.entities.enums.MaritalStatus;
import qc.colval.banksystem.entities.enums.Sex;
import qc.colval.banksystem.services.implementations.AccountServiceImpl;
import qc.colval.banksystem.services.implementations.AddressServiceImpl;
import qc.colval.banksystem.services.implementations.ClientServiceImpl;
import qc.colval.banksystem.services.implementations.ManagerServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class BanksystemApplication {
    private final Logger log = LoggerFactory.getLogger(BanksystemApplication.class);

    private final AccountServiceImpl accountService;
    private final AddressServiceImpl addressService;
    private final ClientServiceImpl clientService;
    private final ManagerServiceImpl managerService;

    public BanksystemApplication(AccountServiceImpl accountService, AddressServiceImpl addressService, ClientServiceImpl clientService, ManagerServiceImpl managerService) {
        this.accountService = accountService;
        this.addressService = addressService;
        this.clientService = clientService;
        this.managerService = managerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BanksystemApplication.class, args);
    }

    @Bean
    void populate() throws InterruptedException {
        //Declaring a few entities with no associations
        Client client1 = new Client();
        client1.setIncome(50000);
        client1.setNip(1234);
        client1.setMaritalStatus(MaritalStatus.Divorced);
        client1.setEmail("jeanguy@gmail.com");
        client1.setFirstName("Jean");
        client1.setLastName("Guy");
        client1.setPhoneNumber("957908656790");
        client1.setSex(Sex.Male);

        Client client2 = new Client();
        client2.setIncome(67000);
        client2.setNip(3453);
        client2.setMaritalStatus(MaritalStatus.Married);
        client2.setEmail("mariemar@gmail.com");
        client2.setFirstName("Marie");
        client2.setLastName("Mar");
        client2.setPhoneNumber("56756720");
        client2.setSex(Sex.Female);


        Address address = new Address();
        address.setPostalCode("J6Y9P0");
        address.setStreetName("Salaberry");

        Account account1 = new Account();
        account1.setBalance(789.92d);
        account1.setType(AccountType.Checking);

        Account account2 = new Account();
        account2.setBalance(9678.12d);
        account2.setType(AccountType.Saving);

        Account account3 = new Account();
        account3.setBalance(5645.34d);
        account3.setType(AccountType.Checking);

        Manager manager = new Manager();
        manager.setEmail("theboss@gmail.com");
        manager.setFirstName("Vladimir");
        manager.setLastName("Isiakov");
        manager.setSex(Sex.Male);
        manager.setPhoneNumber("4934593423");
        manager.setOfficeNumber(123);

        //Linking entities
        Set<User> users = new HashSet<User>();
        users.add(client1);
        users.add(client2);
        users.add(manager);

        Set<Client> clients = new HashSet<Client>();
        clients.add(client1);
        clients.add(client2);

        Set<Account> accounts1 = new HashSet<Account>();
        accounts1.add(account1);

        Set<Account> accounts2 = new HashSet<Account>();
        accounts2.add(account2);
        accounts2.add(account3);

        client1.setManager(manager);
        client2.setManager(manager);
        client1.setAccounts(accounts1);
        client2.setAccounts(accounts2);
        client1.setMainAddress(address);
        client2.setMainAddress(address);
        manager.setClients(clients);
        manager.setMainAddress(address);
        account1.setOwner(client1);
        account2.setOwner(client2);
        address.setUsers(users);

        clientService.create(client1);
        clientService.create(client2);
        managerService.create(manager);
        accountService.create(account1);
        accountService.create(account2);
        accountService.create(account3);
        addressService.create(address);

        //For some reason I need to wait a second before starting crud operations otherwise, find all after deletion omits one record.
        TimeUnit.SECONDS.sleep(1);
        //Testing a few crud operations
        //READ client with id = 1
        log.info("*** CLIENT 1 ***");
        log.info(clientService.findOne(1).toString());
        //READ ALL accounts
        log.info("*** ALL ACCOUNTS ***");
        accountService.findAll().forEach(account -> {
            log.info(account.toString());
        });
        //DELETE account with id 2 and view if it was deleted
        accountService.delete(2);
        log.info("*** ALL ACCOUNTS AFTER DELETION ***");
        accountService.findAll().forEach(account -> {
            log.info(account.toString());
        });
        addressService.findAll().forEach(account -> {
            log.info(account.toString());
        });
    }
}
