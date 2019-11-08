package ua.lviv.iot.service;

import org.hibernate.Session;
import ua.lviv.iot.DAO.implmentetion.RouteDAOImpl;
import ua.lviv.iot.model.Route;
import java.sql.SQLException;
import java.util.List;

public class RouteService {

    public List<Route> findAll(Session session) throws SQLException {
        return new RouteDAOImpl().findAll(session);
    }

    public Route findById(Integer id, Session session) throws SQLException {
        return new RouteDAOImpl().findById(id, session);
    }

    public void create(Route entity, Session session) throws SQLException {
        new RouteDAOImpl().create(entity, session);
    }

    public void update(Route entity, Session session) throws SQLException {
        new RouteDAOImpl().update(entity, session);
    }

    public void delete(Integer id, Session session) throws SQLException {
        new RouteDAOImpl().delete(id, session);
    }

}
