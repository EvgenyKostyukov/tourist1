package com.eugene.repository;

import com.eugene.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {


    Optional<City> findCityByCity(String city);




//    void deleteCityByCity(String name);


}
