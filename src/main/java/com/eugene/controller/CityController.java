package com.eugene.controller;

import com.eugene.model.City;
import com.eugene.service.ICityService;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CityController {

    private final ICityService cityService;

    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    //получение всех городов и инф
    @GetMapping("/cities")
    public List<City> showAllCities() {
        return cityService.getCities();
    }

    //получение  города и инф по ИД
    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable Long id) {
        Optional<City> city = cityService.getCityById(id);
        return city.orElse(null);
    }

    //удаление города и инфо по ИД
    @DeleteMapping("/city/{id}")
    public String deleteCityById(@PathVariable Long id) {
        cityService.deleteCityById(id);
        return "Delete city with id=" + id;
    }

    //добавление города по имени и инфо
    @PostMapping("/city")
    public String createCity(@QueryParam("name") String name, @QueryParam("info") String info) {
        //return cityService
        return "Create city with name=" + name + " and info=" + info;
    }
}


//    @Autowired
//    private CityService cityService;
//
//    @GetMapping("/cities")
//    public List<City> showAllCities() {
//        List<City> allCities = cityService.getAllCities();
//        return allCities;
//    }
//
//    @GetMapping("/cities/{id}")
//    public City getCity(@PathVariable int id) {
//        City city = cityService.getCity(id);
//
//        if (city == null) {
//            throw new NoSuchCityException("There is  no city  with  ID = " +
//                    id + " in  Database");
//        }
//        return city;
//    }
//
//    @GetMapping("api/city")
//    public City getCity(@RequestParam String name) {
//        City city = cityService.getCityByName(name);
//
//        if (city == null) {
//            throw new NoSuchCityException("There is  no city  with  name = " +
//                    name + " in  Database");
//        }
//        return city;
//    }
//
//
//    @PostMapping("/cities")
//    public City addNewCity(@RequestBody City city) {
//        cityService.saveCities(city);
//        return city;
//    }
//
//    @PutMapping("/cities")
//    public City updateCity(@RequestBody City city) {
//        cityService.saveCities(city);
//        return city;
//    }
//
//    @DeleteMapping("/cities/{id}")
//    public String deleteCity(@PathVariable int id) {
//
//        City city = cityService.getCity(id);
//        if (city == null) {
//            throw new NoSuchCityException("There is no city with ID = " +
//                    id + " in Database");
//        }
//
//        cityService.deleteCity(id);
//        return "City with ID = " + id + " was deleted";
//
//    }
//
//
//    @ExceptionHandler
//    public ResponseEntity<CityIncorrectData> handleException(
//            NoSuchCityException exception) {
//        CityIncorrectData data = new CityIncorrectData();
//        data.setInfo(exception.getMessage());
//
//        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
//    }
//
//
//    @ExceptionHandler
//    public ResponseEntity<CityIncorrectData> handleException(
//            Exception exception) {
//        CityIncorrectData data = new CityIncorrectData();
//        data.setInfo(exception.getMessage());
//
//        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
//    }
//


