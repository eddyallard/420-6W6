package qc.colval.demothymleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import qc.colval.demothymleaf.services.CustomerService;

@Controller
@RequestMapping("/")
public class IndexController {
    private final CustomerService customerService;

    public IndexController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("index/")
    public String index(Model model) {
        model.addAttribute("nbCustomer", customerService.countAllCustomer());
        return "index/index";
    }
}
