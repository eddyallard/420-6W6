package qc.colval.banksystem.services.implementations;

import org.springframework.stereotype.Service;
import qc.colval.banksystem.entities.Address;
import qc.colval.banksystem.repositories.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements qc.colval.banksystem.services.AddressService {
    private AddressRepository repos;

    public AddressServiceImpl(AddressRepository repos){
        this.repos = repos;
    }

    @Override
    public Address create(Address entity) {
        return repos.save(entity);
    }

    @Override
    public Optional<Address> findOne(Integer id) {
        return repos.findById(id);
    }

    @Override
    public List<Address> findAll() {
        return repos.findAll();
    }

    @Override
    public void delete(Integer id) {
        repos.deleteById(id);
    }
}
