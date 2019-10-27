package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.RouteGuideDAOImpl;
import ua.com.iot.model.RouteGuide;

import java.sql.SQLException;
import java.util.List;

public class RouteGuideService {

    public List<RouteGuide> findAll() throws SQLException {
        return new RouteGuideDAOImpl().findAll();
    }

    public RouteGuide findById(Integer id) throws SQLException {
        return new RouteGuideDAOImpl().findById(id);
    }

    public int create(RouteGuide entity) throws SQLException {
        return new RouteGuideDAOImpl().create(entity);
    }

    public int update(RouteGuide entity) throws SQLException {
        return new RouteGuideDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new RouteGuideDAOImpl().delete(id);
    }

    public List<RouteGuide> findByGuideId(int id) throws SQLException {
        return new RouteGuideDAOImpl().findByGuideId(id);
    }

    public List<RouteGuide> findByRouteId(int id) throws SQLException {
        return new RouteGuideDAOImpl().findByRouteId(id);
    }

}
