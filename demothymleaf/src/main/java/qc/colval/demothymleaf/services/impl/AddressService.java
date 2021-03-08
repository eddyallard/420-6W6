package qc.colval.demothymleaf.services.impl;

import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.entities.Address;
import qc.colval.demothymleaf.repos.IAddressRepository;
import qc.colval.demothymleaf.services.IAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {
    private final IAddressRepository addressRepository;

    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> readOne(Long addressId) {
        return addressRepository.findById(addressId);
    }

    @Override
    public List<Address> readAll() {
        return addressRepository.findAll();
    }

    @Override
    public void delete(Long addressId) {
        addressRepository.deleteById(addressId);
    }

}
