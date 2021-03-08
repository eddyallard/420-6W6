package qc.colval.demothymleaf.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.demothymleaf.models.entities.Customer;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllCustomerSortedByLastName();
    List<Customer> findByFirstNameSubStr(String subStr);
}
