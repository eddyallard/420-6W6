package qc.colval.demothymleaf.services.impl;

import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.entities.Customer;
import qc.colval.demothymleaf.repos.ICustomerRepository;
import qc.colval.demothymleaf.services.ICustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> readOne(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> readAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomerSortedByLastName() {
        return customerRepository.findAllCustomerSortedByLastName();
    }

    @Override
    public List<Customer> getAllCustomerWithFirstNameSubStr(String subStr) {
        return customerRepository.findByFirstNameSubStr(subStr);
    }

    @Override
    public Customer updateFirstNameAndLastName(Long customerId, String firstName, String lastName) {
        Optional<Customer> customerRecover = this.readOne(customerId);
        if (customerRecover.isEmpty()) throw new RuntimeException("Customer Id not found");
        Customer customer = customerRecover.get();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customerRepository.save(customer);
        }

    @Override
    public Long countAllCustomer() {
        return customerRepository.count();
    }
}
