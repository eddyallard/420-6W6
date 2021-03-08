package qc.colval.demothymleaf.services;

import qc.colval.demothymleaf.models.entities.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {
    Country create(Country country);

    Optional<Country> readOne(Long countryId);

    List<Country> readAll();

    void delete(Long countryId);

    Long countAllCountry();

}
