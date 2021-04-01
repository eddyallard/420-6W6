package qc.colval.demothymleaf.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qc.colval.demothymleaf.models.dto.CustomerDTO;
import qc.colval.demothymleaf.models.entities.Customer;
import qc.colval.demothymleaf.services.CustomerService;
import qc.colval.demothymleaf.services.mappers.EntityMapper;

<<<<<<< HEAD
=======
import javax.swing.text.html.parser.Entity;
>>>>>>> parent of cb483be (renaming)
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerRessource {
    private final CustomerService customerService;
    private final EntityMapper<Customer, CustomerDTO> mapper;

    @GetMapping
<<<<<<< HEAD
    public List<CustomerDTO> getAll() {
        return this.customerService.readAll().stream()
=======
    public List<CustomerDTO> getAll(){
        return customerService.readAll().stream()
>>>>>>> parent of cb483be (renaming)
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
<<<<<<< HEAD
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Customer> customer = this.customerService.readOne(id);
=======
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Customer> customer = customerService.readOne(id);
>>>>>>> parent of cb483be (renaming)
        return customer.map(value -> ResponseEntity.ok(mapper.entityToDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
