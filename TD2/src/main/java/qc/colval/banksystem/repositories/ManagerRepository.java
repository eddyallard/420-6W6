package qc.colval.banksystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.banksystem.entities.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
