package ua.lviv.iot.DAO.implmentetion;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.RouteGuideDAO;
import ua.lviv.iot.model.RouteGuide;

import java.util.ArrayList;
import java.util.List;

public class RouteGuideDAOImpl implements RouteGuideDAO {

    public void create(RouteGuide entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(RouteGuide entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(Integer id, Session session) {
        session.beginTransaction();
        RouteGuide obj = findById(id, session);
        session.delete(obj);
        session.getTransaction().commit();
    }

    public List<RouteGuide> findAll(Session session) {
        List<RouteGuide> cities = new ArrayList<>();
        Query query = session.createQuery("from " + "RouteGuide ");
        for (Object obj : query.list()){
            cities.add((RouteGuide) obj);
        }
        return cities;
    }

    public RouteGuide findById(Integer id, Session session) {
        return session.get(RouteGuide.class, id);
    }
}