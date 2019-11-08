package ua.lviv.iot.DAO.implmentetion;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.CityDAO;
import ua.lviv.iot.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO {

    public void create(City entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(City entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(Integer id, Session session) {
        session.beginTransaction();
        City obj = findById(id, session);
        session.delete(obj);
        session.getTransaction().commit();
    }

    public List<City> findAll(Session session) {
        List<City> cities = new ArrayList<>();
        Query query = session.createQuery("from " + "City ");
        for (Object obj : query.list()){
            cities.add((City) obj);
        }
        return cities;
    }

    public City findById(Integer id, Session session) {
        return session.get(City.class, id);
    }
}
