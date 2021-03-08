package qc.colval.demothymleaf.services.impl;

import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.entities.Country;
import qc.colval.demothymleaf.services.ICountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    @Override
    public Country create(Country country) {
        return null;
    }

    @Override
    public Optional<Country> readOne(Long countryId) {
        return Optional.empty();
    }

    @Override
    public List<Country> readAll() {
        return null;
    }

    @Override
    public void delete(Long countryId) {

    }

    @Override
    public Long countAllCountry() {
        return null;
    }
}
