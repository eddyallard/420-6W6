package qc.colval.demothymleaf.services.mappers;

import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.dto.CustomerDTO;
import qc.colval.demothymleaf.models.entities.Customer;

@Service
public class CustomerMapper implements EntityMapper<Customer, CustomerDTO>{
    @Override
    public CustomerDTO entityToDto(Customer customer) {
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getActive(),
                customer.getCreateDate(),
                customer.getLastUpdate(),
                customer.getAddress().getAddressId(),
                customer.getStore().getStoreId()
        );
    }
}
