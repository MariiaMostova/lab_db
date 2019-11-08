package ua.lviv.iot.DAO.implmentetion;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.RouteDAO;
import ua.lviv.iot.model.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteDAOImpl implements RouteDAO {

    public void create(Route entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(Route entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(Integer id, Session session) {
        session.beginTransaction();
        Route obj = findById(id, session);
        session.delete(obj);
        session.getTransaction().commit();
    }

    public List<Route> findAll(Session session) {
        List<Route> cities = new ArrayList<>();
        Query query = session.createQuery("from " + "Route ");
        for (Object obj : query.list()){
            cities.add((Route) obj);
        }
        return cities;
    }

    public Route findById(Integer id, Session session) {
        return session.get(Route.class, id);
    }
}
