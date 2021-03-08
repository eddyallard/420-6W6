package qc.colval.demothymleaf.services;

import qc.colval.demothymleaf.models.entities.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressService {
    public Address create(Address address);
    public Optional<Address> readOne(Long addressId);
    public List<Address> readAll();
    public void delete(Long addressId);
}
