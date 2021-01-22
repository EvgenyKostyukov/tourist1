package server.dao;


import server.entity.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CityDAOImpl implements CityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<City> getAllCities() {
        Session session = sessionFactory.getCurrentSession();
        Query<City> query = session.createQuery("from City",
                City.class);
        List<City> allCity = query.getResultList();
        return allCity;
    }

    @Override
    public void saveCities(City city) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(city);

    }

    @Override
    public City getCity(int id) {
        Session session = sessionFactory.getCurrentSession();
        City city = session.get(City.class, id);
        return city;
    }

    @Override
    public void deleteCity(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<City> query = session.createQuery("delete from City " +
                "where id = :cityId");
        query.setParameter("cityId", id);
        query.executeUpdate();
    }

        @Override
    public City getCityByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<City> query = session.createQuery("from City where name =" + name,
                City.class);
        return query.getSingleResult();
    }
}

