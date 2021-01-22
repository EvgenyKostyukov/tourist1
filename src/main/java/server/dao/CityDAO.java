package server.dao;

import server.entity.City;

import java.util.List;

public interface CityDAO {
    List<City> getAllCities();

    City getCityByName(String name);

    void saveCities(City city);

    City getCity(int id);

    void deleteCity(int id);
}
