package ua.lviv.iot.DAO.implmentetion;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.TourDAO;
import ua.lviv.iot.model.Tour;

import java.util.ArrayList;
import java.util.List;

public class TourDAOImpl implements TourDAO {

    public void create(Tour entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(Tour entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(Integer id, Session session) {
        session.beginTransaction();
        Tour obj = findById(id, session);
        session.delete(obj);
        session.getTransaction().commit();
    }

    public List<Tour> findAll(Session session) {
        List<Tour> cities = new ArrayList<>();
        Query query = session.createQuery("from " + "Tour ");
        for (Object obj : query.list()){
            cities.add((Tour) obj);
        }
        return cities;
    }

    public Tour findById(Integer id, Session session) {
        return session.get(Tour.class, id);
    }
}
