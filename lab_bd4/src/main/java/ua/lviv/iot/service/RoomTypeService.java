package ua.lviv.iot.service;

import org.hibernate.Session;
import ua.lviv.iot.DAO.implmentetion.RoomTypeDAOImpl;
import ua.lviv.iot.model.RoomType;
import java.sql.SQLException;
import java.util.List;

public class RoomTypeService {

    public List<RoomType> findAll(Session session) throws SQLException {
        return new RoomTypeDAOImpl().findAll(session);
    }

    public RoomType findById(Integer id, Session session) throws SQLException {
        return new RoomTypeDAOImpl().findById(id, session);
    }

    public void create(RoomType entity, Session session) throws SQLException {
        new RoomTypeDAOImpl().create(entity, session);
    }

    public void update(RoomType entity, Session session) throws SQLException {
        new RoomTypeDAOImpl().update(entity, session);
    }

    public void delete(Integer id, Session session) throws SQLException {
        new RoomTypeDAOImpl().delete(id, session);
    }

}