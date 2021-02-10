package qc.colval.banksystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.banksystem.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
