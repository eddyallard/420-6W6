package qc.colval.demodbfirst.services;

import org.springframework.stereotype.Service;
import qc.colval.demodbfirst.models.entities.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService{
    Customer create(Customer customer);

    Optional<Customer> readOne(Long id);

    List<Customer> readAll();

    void delete(Long id);

    List<Customer> getAllCustomerSortedByLastName();

    Customer updateFirstNameAndLastName(Long customerId,String firstName,String lastName);

}
