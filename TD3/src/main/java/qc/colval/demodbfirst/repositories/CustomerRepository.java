package qc.colval.demodbfirst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.demodbfirst.models.entities.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllCustomerSortedByLastName();
}
