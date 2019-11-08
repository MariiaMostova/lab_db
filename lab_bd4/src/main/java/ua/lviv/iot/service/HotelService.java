package ua.lviv.iot.service;

import org.hibernate.Session;
import ua.lviv.iot.DAO.implmentetion.HotelDAOImpl;
import ua.lviv.iot.model.Hotel;
import java.sql.SQLException;
import java.util.List;

public class HotelService {

    public List<Hotel> findAll(Session session) throws SQLException {
        return new HotelDAOImpl().findAll(session);
    }

    public Hotel findById(Integer id, Session session) throws SQLException {
        return new HotelDAOImpl().findById(id, session);
    }

    public void create(Hotel entity, Session session) throws SQLException {
        new HotelDAOImpl().create(entity, session);
    }

    public void update(Hotel entity, Session session) throws SQLException {
        new HotelDAOImpl().update(entity, session);
    }

    public void delete(Integer id, Session session) throws SQLException {
        new HotelDAOImpl().delete(id, session);
    }

}