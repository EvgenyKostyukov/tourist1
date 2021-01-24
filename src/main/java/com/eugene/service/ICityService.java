package com.eugene.service;

import com.eugene.model.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {

    List<City> getCities();

    Optional<City> getCityById(Long id);

    Optional<City> getCityByName(String name);

    void deleteCityById(Long id);

//    <String extends City> String createCity (String info);






}
