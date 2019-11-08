package ua.lviv.iot.DAO.implmentetion;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.GuideDAO;
import ua.lviv.iot.model.Guide;

import java.util.ArrayList;
import java.util.List;

public class GuideDAOImpl implements GuideDAO {

    public void create(Guide entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(Guide entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(Integer id, Session session) {
        session.beginTransaction();
        Guide obj = findById(id, session);
        session.delete(obj);
        session.getTransaction().commit();
    }

    public List<Guide> findAll(Session session) {
        List<Guide> cities = new ArrayList<>();
        Query query = session.createQuery("from " + "Guide ");
        for (Object obj : query.list()){
            cities.add((Guide) obj);
        }
        return cities;
    }

    public Guide findById(Integer id, Session session) {
        return session.get(Guide.class, id);
    }
}