package qc.colval.banksystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import qc.colval.banksystem.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
