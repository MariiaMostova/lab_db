package ua.lviv.iot.DAO.implmentetion;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.HotelDAO;
import ua.lviv.iot.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {

    public void create(Hotel entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(Hotel entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(Integer id, Session session) {
        session.beginTransaction();
        Hotel obj = findById(id, session);
        session.delete(obj);
        session.getTransaction().commit();
    }

    public List<Hotel> findAll(Session session) {
        List<Hotel> cities = new ArrayList<>();
        Query query = session.createQuery("from " + "Hotel ");
        for (Object obj : query.list()){
            cities.add((Hotel) obj);
        }
        return cities;
    }

    public Hotel findById(Integer id, Session session) {
        return session.get(Hotel.class, id);
    }
}