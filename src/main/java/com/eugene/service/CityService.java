package com.eugene.service;

import com.eugene.model.City;
import com.eugene.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getCities() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public Optional<City> getCityByName(String name) {
        return cityRepository.findCityByCity(name);
    }

    @Override
    public void deleteCityById(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City saveCity(City city) {
        City savedCity = cityRepository.save(city);
        return savedCity;
    }
}

