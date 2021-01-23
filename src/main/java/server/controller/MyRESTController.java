package server.controller;

import server.entity.City;
import server.exception_handling.CityIncorrectData;
import server.exception_handling.NoSuchCityException;
import server.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> showAllCities() {
        List<City> allCities = cityService.getAllCities();
        return allCities;
    }

    @GetMapping("/cities/{id}")
    public City getCity(@PathVariable int id) {
        City city = cityService.getCity(id);

        if (city == null) {
            throw new NoSuchCityException("There is  no city  with  ID = " +
                    id + " in  Database");
        }
        return city;
    }

    @GetMapping("api/city")
    public City getCity(@RequestParam String name) {
        City city = cityService.getCityByName(name);

        if (city == null) {
            throw new NoSuchCityException("There is  no city  with  name = " +
                    name + " in  Database");
        }
        return city;
    }


@PostMapping("/cities")
    public City addNewCity(@RequestBody City city){
        cityService.saveCities(city);
        return city;
}

@PutMapping("/cities")
public City updateCity(@RequestBody City city){
        cityService.saveCities(city);
        return city;
}

@DeleteMapping("/cities/{id}")
    public  String deleteCity(@PathVariable int id){

        City city = cityService.getCity(id);
        if(city == null){
            throw new NoSuchCityException("There is no city with ID = " +
                    id + " in Database");
        }

        cityService.deleteCity(id);
        return "City with ID = " + id + " was deleted";

}



    @ExceptionHandler
    public ResponseEntity<CityIncorrectData> handleException(
            NoSuchCityException exception) {
        CityIncorrectData data = new CityIncorrectData();
        data.setInfo(exception.getMessage() );

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<CityIncorrectData> handleException(
            Exception exception) {
        CityIncorrectData data = new CityIncorrectData();
        data.setInfo(exception.getMessage() );

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }


}
