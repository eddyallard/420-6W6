package qc.colval.demothymleaf.services;

import org.springframework.stereotype.Service;
import qc.colval.demothymleaf.models.entities.City;
import qc.colval.demothymleaf.repos.ICityRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService{

    private final ICityRepository cityRepository;

    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City create(City city) {
        return cityRepository.save(city);
    }

    public Optional<City> readOne(Long cityId) {
        return cityRepository.findById(cityId);
    }

    public List<City> readAll() {
        return cityRepository.findAll();
    }

    public void delete(Long cityId) {
        cityRepository.deleteById(cityId);
    }

    public Long countAllCity() {
        return cityRepository.count();
    }

    public List<City> getAllTenRandomCity() {
        List<City> cities = cityRepository.findAll();
        Collections.shuffle(cities);
        return cities.stream().limit(10).collect(Collectors.toList());

    }
}
