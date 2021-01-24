package com.eugene.service;

import com.eugene.model.City;
import com.eugene.repository.CityRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public String saveCity(City city) {
        City  savedCity = cityRepository.save(city);
        if(savedCity!=null){
            return "Saved";
        }else {

        }
        return "Failed";
    }


}

//    @Override
//    public void saveCities(City city) {
//        ICityService.saveCities(city);
//    }


//    @Override
//    public City createCity(City city) {
//        return cityRepository.save(city);
//    }
//}

//    @Override
//    public City createCity(City city) {
//       return null;
//    }

//    @Override
//    public void createCity(City city) {
//        cityRepository.createCity(city);
//    }



