package qc.colval.demothymleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import qc.colval.demothymleaf.services.impl.CustomerService;

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
        model.addAttribute("allCustomer", customerService.readAll().stream().limit(15).collect(Collectors.toList()));
        model.addAttribute("customerCount", customerService.readAll().size());
        return "customer/customer";
    }
}
