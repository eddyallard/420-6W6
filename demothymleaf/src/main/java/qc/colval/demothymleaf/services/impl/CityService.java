package qc.colval.demothymleaf.services.impl;

import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.entities.City;
import qc.colval.demothymleaf.repos.ICityRepository;
import qc.colval.demothymleaf.services.ICityService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class CityService implements ICityService {

    private final ICityRepository cityRepository;

    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public Optional<City> readOne(Long cityId) {
        return cityRepository.findById(cityId);
    }

    @Override
    public List<City> readAll() {
        return cityRepository.findAll();
    }

    @Override
    public void delete(Long cityId) {
        cityRepository.deleteById(cityId);
    }

    @Override
    public Long countAllCity() {
        return cityRepository.count();
    }

    @Override
    public List<City> getAllTenRandomCity() {
        List<City> cities = cityRepository.findAll();
        Collections.shuffle(cities);
        return cities.stream().limit(10).collect(Collectors.toList());

    }
}
