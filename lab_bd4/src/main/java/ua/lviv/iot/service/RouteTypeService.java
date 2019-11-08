package ua.lviv.iot.service;

import org.hibernate.Session;
import ua.lviv.iot.DAO.implmentetion.RouteTypeDAOImpl;
import ua.lviv.iot.model.RouteType;
import java.sql.SQLException;
import java.util.List;

public class RouteTypeService {

    public List<RouteType> findAll(Session session) throws SQLException {
        return new RouteTypeDAOImpl().findAll(session);
    }

    public RouteType findById(Integer id, Session session) throws SQLException {
        return new RouteTypeDAOImpl().findById(id, session);
    }

    public void create(RouteType entity, Session session) throws SQLException {
        new RouteTypeDAOImpl().create(entity, session);
    }

    public void update(RouteType entity, Session session) throws SQLException {
        new RouteTypeDAOImpl().update(entity, session);
    }

    public void delete(Integer id, Session session) throws SQLException {
        new RouteTypeDAOImpl().delete(id, session);
    }

}