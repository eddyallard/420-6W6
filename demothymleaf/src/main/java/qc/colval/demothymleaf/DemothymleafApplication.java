package qc.colval.demothymleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import qc.colval.demothymleaf.models.entities.City;
import qc.colval.demothymleaf.services.impl.*;

@SpringBootApplication
public class DemothymleafApplication {
    /*@Autowired
    private ActorService actorService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private StoreService storeService;*/
    public static void main(String[] args) {
        SpringApplication.run(DemothymleafApplication.class, args);
    }

}
