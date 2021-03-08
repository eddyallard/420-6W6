package qc.colval.demothymleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import qc.colval.demothymleaf.services.impl.CustomerService;

@Controller
public class IndexController {
    private final CustomerService customerService;

    public IndexController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("nbCustomer", customerService.countAllCustomer());
        return "index/index";
    }
}
