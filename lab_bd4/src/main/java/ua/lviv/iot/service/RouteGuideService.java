package ua.lviv.iot.service;

import org.hibernate.Session;
import ua.lviv.iot.DAO.implmentetion.RouteGuideDAOImpl;
import ua.lviv.iot.model.RouteGuide;
import java.sql.SQLException;
import java.util.List;

public class RouteGuideService {

    public List<RouteGuide> findAll(Session session) throws SQLException {
        return new RouteGuideDAOImpl().findAll(session);
    }

    public RouteGuide findById(Integer id, Session session) throws SQLException {
        return new RouteGuideDAOImpl().findById(id, session);
    }

    public void create(RouteGuide entity, Session session) throws SQLException {
        new RouteGuideDAOImpl().create(entity, session);
    }

    public void update(RouteGuide entity, Session session) throws SQLException {
        new RouteGuideDAOImpl().update(entity, session);
    }

    public void delete(Integer id, Session session) throws SQLException {
        new RouteGuideDAOImpl().delete(id, session);
    }

}