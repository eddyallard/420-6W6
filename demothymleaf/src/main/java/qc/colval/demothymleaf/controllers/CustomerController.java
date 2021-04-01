package qc.colval.demothymleaf.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import qc.colval.demothymleaf.models.view_models.SearchNameViewModel;
import qc.colval.demothymleaf.models.dto.CustomerDTO;
import qc.colval.demothymleaf.models.entities.Address;
import qc.colval.demothymleaf.models.entities.Customer;
import qc.colval.demothymleaf.models.entities.Store;
import qc.colval.demothymleaf.services.AddressService;
import qc.colval.demothymleaf.services.CustomerService;
import qc.colval.demothymleaf.services.StoreService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final StoreService storeService;
    private final AddressService addressService;

    @GetMapping("/all")
    public String customer(Model model){
        model.addAttribute("searchNames", new SearchNameViewModel());
        model.addAttribute("allCustomer", customerService.readAll().stream().limit(20).collect(Collectors.toList()));
        model.addAttribute("customerCount", customerService.readAll().size());
        return "customer/customer";
    }
    @GetMapping("/{id}")
    public String getCustomer(Model model, @PathVariable Long id){

        Optional<Customer> customer=customerService.readOne(id);

        model.addAttribute("customer",customer.get());

        return "customer/detail";

    }


    @PostMapping("/do_search_name")
    public String searchCustomerByName(Model model, SearchNameViewModel searchNameViewModel){
        String firstNameSubStr = searchNameViewModel.getFirstname();
        List<Customer> customersWithName = customerService.getAllCustomerWithFirstNameSubStr(firstNameSubStr);
        int nbCustomers = customersWithName.size();
        model.addAttribute("searchNames", new SearchNameViewModel(firstNameSubStr));
        model.addAttribute("allCustomer",customersWithName);
        model.addAttribute("customerCount", nbCustomers);
        return "customer/customer";
    }

    @GetMapping("/new")
    public String showAddForms(Model model) {
        List<Address> addresses = addressService.readAll();
        List<Store> stores = storeService.readAll();
        model.addAttribute("customer", new CustomerDTO());
        model.addAttribute("addresses", addresses);
        model.addAttribute("stores", stores);
        return "customer/add";
    }

    @PostMapping("/save")
    public String addCustomer(@Valid CustomerDTO customerDTO){
        Customer customer;
        Optional<Address> address = addressService.readOne(customerDTO.getAddressId());
        System.out.println(customerDTO.toString());
        if (customerDTO.getCustomerId() != null){
            customer = customerService.readOne(customerDTO.getCustomerId()).orElseThrow(() -> new IllegalArgumentException("Customer Id not found")); // l'exception ne crash pas l'app; elle sert de "confirmation"
            customer.setCustomerId(customerDTO.getCustomerId());
        } else {
            //Cette partie est un placeholder, pas nécéssaire, c'est pourquoi ça ne fait pas beaucoup de sens.
            Store store = storeService.readAll().stream().findFirst().orElse(null);
            customer = new Customer();
            customer.setStore(store);
        }
        if (customerDTO.getCreateDate() != null) customer.setCreateDate(customerDTO.getCreateDate()); //post new customer
        customer.setActive(customerDTO.isActive());
        customer.setEmail(customerDTO.getEmail());
        customer.setLastName(customerDTO.getLastName());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setAddress(address.orElseThrow(null));
        customer.setLastUpdate(new Date());
        customerService.create(customer);

        return "redirect:/customer/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable long id) {
        customerService.delete(id);
        System.out.println("Client #" + id +" supprimé!");
        return "redirect:/customer/all";
    }
}
