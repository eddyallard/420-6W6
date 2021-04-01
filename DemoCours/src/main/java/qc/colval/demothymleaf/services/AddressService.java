package qc.colval.demothymleaf.services;

import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.entities.Address;
import qc.colval.demothymleaf.repos.IAddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService{
    private final IAddressRepository addressRepository;

    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address create(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Address> readOne(Long addressId) {
        return addressRepository.findById(addressId);
    }

    public List<Address> readAll() {
        return addressRepository.findAll();
    }

    public void delete(Long addressId) {
        addressRepository.deleteById(addressId);
    }

}
