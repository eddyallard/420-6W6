package qc.colval.banksystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.banksystem.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
