package qc.colval.demothymleaf.services;

import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.entities.Customer;

import java.util.List;
import java.util.Optional;


public interface ICustomerService{
    Customer create(Customer customer);

    Optional<Customer> readOne(Long id);

    List<Customer> readAll();

    void delete(Long id);

    List<Customer> getAllCustomerSortedByLastName();

    List<Customer> getAllCustomerWithFirstNameSubStr(String subStr);

    Customer updateFirstNameAndLastName(Long customerId,String firstName,String lastName);

    Long countAllCustomer();

}
