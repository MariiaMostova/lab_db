package ua.lviv.iot.DAO.implmentetion;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.StopPointDAO;
import ua.lviv.iot.model.StopPoint;

import java.util.ArrayList;
import java.util.List;

public class StopPointDAOImpl implements StopPointDAO {

    public void create(StopPoint entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(StopPoint entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(Integer id, Session session) {
        session.beginTransaction();
        StopPoint obj = findById(id, session);
        session.delete(obj);
        session.getTransaction().commit();
    }

    public List<StopPoint> findAll(Session session) {
        List<StopPoint> cities = new ArrayList<>();
        Query query = session.createQuery("from " + "StopPoint ");
        for (Object obj : query.list()){
            cities.add((StopPoint) obj);
        }
        return cities;
    }

    public StopPoint findById(Integer id, Session session) {
        return session.get(StopPoint.class, id);
    }
}