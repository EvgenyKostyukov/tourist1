package server.dao;

import server.entity.City;

import java.util.List;

public interface CityDAO {
    public List<City> getAllCities();

    City getCityByName(String name);

    public void saveCities(City city);

    public City getCity(int id);

    public  void deleteCity(int id);
}
