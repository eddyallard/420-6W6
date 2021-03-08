package qc.colval.demothymleaf.controllers;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import qc.colval.demothymleaf.controllers.viewmodels.SearchNameViewModel;
import qc.colval.demothymleaf.models.entities.Customer;
import qc.colval.demothymleaf.services.impl.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public String customer(Model model){
        model.addAttribute("searchNames", new SearchNameViewModel());
        model.addAttribute("allCustomer", customerService.readAll().stream().limit(20).collect(Collectors.toList()));
        model.addAttribute("customerCount", customerService.readAll().size());
        return "customer/customer";
    }

    @PostMapping("/do_search_name")
    public String searchCustomerByName(Model model, SearchNameViewModel searchNameViewModel){
        List<Customer> customersWithName = customerService.getAllCustomerWithFirstNameSubStr(searchNameViewModel.getFirstname());
        int nbCustomers = customersWithName.size();
        model.addAttribute("searchNames", new SearchNameViewModel());
        model.addAttribute("allCustomer",customersWithName);
        model.addAttribute("customerCount", nbCustomers);
        return "customer/customer";
    }
}
