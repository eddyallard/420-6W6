package qc.colval.demothymleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import qc.colval.demothymleaf.services.ICityService;

@Controller
@RequestMapping("/city")
public class CityController {
    private final ICityService cityService;

    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public String city(Model model){
        model.addAttribute("cities", cityService.getAllTenRandomCity());
        return "city/city";
    }
}
