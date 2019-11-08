package ua.lviv.iot.DAO.implmentetion;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.RoomTypeDAO;
import ua.lviv.iot.model.RoomType;

import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAOImpl implements RoomTypeDAO {

    public void create(RoomType entity, Session session) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(RoomType entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(Integer id, Session session) {
        session.beginTransaction();
        RoomType obj = findById(id, session);
        session.delete(obj);
        session.getTransaction().commit();
    }

    public List<RoomType> findAll(Session session) {
        List<RoomType> cities = new ArrayList<>();
        Query query = session.createQuery("from " + "RoomType ");
        for (Object obj : query.list()){
            cities.add((RoomType) obj);
        }
        return cities;
    }

    public RoomType findById(Integer id, Session session) {
        return session.get(RoomType.class, id);
    }
}
