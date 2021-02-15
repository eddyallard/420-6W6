package qc.colval.demodbfirst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import qc.colval.demodbfirst.models.entities.Customer;
import qc.colval.demodbfirst.services.impl.CustomerServiceImpl;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemodbfirstApplication {
    private final Logger log = LoggerFactory.getLogger(DemodbfirstApplication.class);

    @Autowired
    private CustomerServiceImpl customerService;


    public static void main(String[] args) {
        SpringApplication.run(DemodbfirstApplication.class, args);
    }
    @Bean
    void requestCustomer() {

        //get all customers
        //List<Customer> customers = customerService.readAll();
        //log.info("All customers {} ", customers.toString());

        //get all customers sorted by lastname
        List<Customer> customers1 = customerService.getAllCustomerSortedByLastName();
        log.info("All customers sorted by lastname {} ", customers1.toString());

        //get customer by id
        Optional<Customer> customerRecover = customerService.readOne((long) 11);
        customerRecover.ifPresent(c -> log.info("Get one customer {} ", c.toString()));

        //update customer
        Customer customerUpdated = customerService.updateFirstNameAndLastName((long) 1, "STEPHANIE", "CLARA");
        log.info("Customer updated {} ", customerUpdated.toString());
    }


}
