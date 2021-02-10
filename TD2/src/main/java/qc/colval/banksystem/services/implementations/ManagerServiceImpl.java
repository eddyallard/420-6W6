package qc.colval.banksystem.services.implementations;

import org.springframework.stereotype.Service;
import qc.colval.banksystem.entities.Manager;
import qc.colval.banksystem.repositories.ManagerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements qc.colval.banksystem.services.ManagerService {
    private ManagerRepository repos;

    public ManagerServiceImpl(ManagerRepository repos){
        this.repos = repos;
    }
    @Override
    public Manager create(Manager entity) {
        return repos.save(entity);
    }

    @Override
    public Optional<Manager> findOne(Integer id) {
        return repos.findById(id);
    }

    @Override
    public List<Manager> findAll() {
        return repos.findAll();
    }

    @Override
    public void delete(Integer id) {
        repos.deleteById(id);
    }
}
