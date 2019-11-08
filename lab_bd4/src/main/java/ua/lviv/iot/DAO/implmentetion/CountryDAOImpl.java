package ua.lviv.iot.DAO.implmentetion;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.CountryDAO;
import ua.lviv.iot.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryDAOImpl implements CountryDAO {

    public void create(Country entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(Country entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(Integer id, Session session) {
        session.beginTransaction();
        Country obj = findById(id, session);
        session.delete(obj);
        session.getTransaction().commit();
    }

    public List<Country> findAll(Session session) {
        List<Country> cities = new ArrayList<>();
        Query query = session.createQuery("from " + "Country ");
        for (Object obj : query.list()){
            cities.add((Country) obj);
        }
        return cities;
    }

    public Country findById(Integer id, Session session) {
        return session.get(Country.class, id);
    }
}