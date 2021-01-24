package com.eugene.controller;

import com.eugene.model.City;
import com.eugene.service.ICityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CityController {
    private final ICityService cityService;

    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<City> showAllCities() {
        return cityService.getCities();
    }

    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable Long id) {
        Optional<City> city = cityService.getCityById(id);
        return city.orElse(null);
    }

    @DeleteMapping("/city/{id}")
    public String deleteCityById(@PathVariable Long id) {
        cityService.deleteCityById(id);
        return "Delete city with id=" + id;
    }

    @PostMapping("/saveCity")
    public City saveCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    @PutMapping("/updateCity")
    public City updateCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }
}



