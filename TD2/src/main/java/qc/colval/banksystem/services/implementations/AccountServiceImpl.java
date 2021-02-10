package qc.colval.banksystem.services.implementations;

import org.springframework.stereotype.Service;
import qc.colval.banksystem.entities.Account;
import qc.colval.banksystem.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements qc.colval.banksystem.services.AccountService {
    private AccountRepository repos;

    public AccountServiceImpl(AccountRepository repos){
        this.repos = repos;
    }

    @Override
    public Account create(Account entity) {
        return repos.save(entity);
    }

    @Override
    public Optional<Account> findOne(Integer id) {
        return repos.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return repos.findAll();
    }

    @Override
    public void delete(Integer id) {
        repos.deleteById(id);
    }
}
