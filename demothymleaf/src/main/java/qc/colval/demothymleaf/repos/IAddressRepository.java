package qc.colval.demothymleaf.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.demothymleaf.models.entities.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
