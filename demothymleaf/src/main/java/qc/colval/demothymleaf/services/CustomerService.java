package qc.colval.demothymleaf.services;

import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.entities.Customer;
import qc.colval.demothymleaf.repos.ICustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService{
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> readOne(Long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> readAll() {
        return customerRepository.findAll();
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> getAllCustomerSortedByLastName() {
        return customerRepository.findAllCustomerSortedByLastName();
    }

    public List<Customer> getAllCustomerWithFirstNameSubStr(String subStr) {
        return customerRepository.findByFirstNameSubStr(subStr);
    }

    public Customer updateFirstNameAndLastName(Long customerId, String firstName, String lastName) {
        Optional<Customer> customerRecover = this.readOne(customerId);
        if (customerRecover.isEmpty()) throw new RuntimeException("Customer Id not found");
        Customer customer = customerRecover.get();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customerRepository.save(customer);
        }

    public Long countAllCustomer() {
        return customerRepository.count();
    }
}
