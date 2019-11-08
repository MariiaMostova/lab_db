package ua.lviv.iot.service;

import org.hibernate.Session;
import ua.lviv.iot.DAO.implmentetion.StopPointDAOImpl;
import ua.lviv.iot.model.StopPoint;
import java.sql.SQLException;
import java.util.List;

public class StopPointService {

    public List<StopPoint> findAll(Session session) throws SQLException {
        return new StopPointDAOImpl().findAll(session);
    }

    public StopPoint findById(Integer id, Session session) throws SQLException {
        return new StopPointDAOImpl().findById(id, session);
    }

    public void create(StopPoint entity, Session session) throws SQLException {
        new StopPointDAOImpl().create(entity, session);
    }

    public void update(StopPoint entity, Session session) throws SQLException {
        new StopPointDAOImpl().update(entity, session);
    }

    public void delete(Integer id, Session session) throws SQLException {
        new StopPointDAOImpl().delete(id, session);
    }

}