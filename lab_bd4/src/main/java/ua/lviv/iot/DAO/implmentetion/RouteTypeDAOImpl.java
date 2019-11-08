package ua.lviv.iot.DAO.implmentetion;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.RouteTypeDAO;
import ua.lviv.iot.model.RouteType;

import java.util.ArrayList;
import java.util.List;

public class RouteTypeDAOImpl implements RouteTypeDAO {

    public void create(RouteType entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(RouteType entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(Integer id, Session session) {
        session.beginTransaction();
        RouteType obj = findById(id, session);
        session.delete(obj);
        session.getTransaction().commit();
    }

    public List<RouteType> findAll(Session session) {
        List<RouteType> cities = new ArrayList<>();
        Query query = session.createQuery("from " + "RouteType ");
        for (Object obj : query.list()){
            cities.add((RouteType) obj);
        }
        return cities;
    }

    public RouteType findById(Integer id, Session session) {
        return session.get(RouteType.class, id);
    }
}