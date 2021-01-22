package server.service;

import server.entity.City;

import java.util.List;

public interface CityService {
    public List<City> getAllCities();

    City getCityByName(String name);

    public void saveCities(City city);

    public City getCity(int id);

    public  void deleteCity(int id);

}
