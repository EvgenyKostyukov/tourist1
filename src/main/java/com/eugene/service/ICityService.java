package com.eugene.service;

import com.eugene.model.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {

    List<City> getCities();

    Optional<City> getCityById(Long id);

    Optional<City> getCityByName(String name);

    void deleteCityById(Long id);

//    void saveCities(City city);

    String saveCity(City city);

//    void saveCities(City city);

//    City createCity(City city);

//    <S extends City> S createCity (S city, S info);


//    void createCity(City city);




}
