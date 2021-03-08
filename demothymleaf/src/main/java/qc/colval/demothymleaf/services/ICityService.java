package qc.colval.demothymleaf.services;

import qc.colval.demothymleaf.models.entities.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    City create(City city);

    Optional<City> readOne(Long cityId);

    List<City> readAll();

    void delete(Long cityId);

    Long countAllCity();

    List<City> getAllTenRandomCity();

}
