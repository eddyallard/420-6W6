package qc.colval.banksystem.services.implementations;

import org.springframework.stereotype.Service;
import qc.colval.banksystem.entities.Client;
import qc.colval.banksystem.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements qc.colval.banksystem.services.ClientService {
    private ClientRepository repos;

    public ClientServiceImpl(ClientRepository repos){
        this.repos = repos;
    }
    @Override
    public Client create(Client entity) {
        return repos.save(entity);
    }

    @Override
    public Optional<Client> findOne(Integer id) {
        return repos.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return repos.findAll();
    }

    @Override
    public void delete(Integer id) {
        repos.deleteById(id);
    }
}
