package com.eugene.controller;

import com.eugene.model.City;
import com.eugene.service.ICityService;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
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
    public Response getCityById(@PathVariable Long id) {
        Optional<City> city = cityService.getCityById(id);
        if (city.isPresent()) {
            return Response.status(Response.Status.OK).entity(city).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Города с таким айди нет").build();
        }
    }

    @DeleteMapping("/city/{id}")
    public void deleteCityById(@PathVariable Long id) {
        cityService.deleteCityById(id);
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



