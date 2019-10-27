package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.RouteStopPointDAOImpl;
import ua.com.iot.model.RouteStopPoint;

import java.sql.SQLException;
import java.util.List;

public class RouteStopPointService {

    public List<RouteStopPoint> findAll() throws SQLException {
        return new RouteStopPointDAOImpl().findAll();
    }

    public int create(RouteStopPoint entity) throws SQLException {
        return new RouteStopPointDAOImpl().create(entity);
    }

    public int update(RouteStopPoint entity) throws SQLException {
        return new RouteStopPointDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new RouteStopPointDAOImpl().delete(id);
    }

    public List<RouteStopPoint> findByStopPointId(int id) throws SQLException {
        return new RouteStopPointDAOImpl().findByStopPointId(id);
    }

    public List<RouteStopPoint> findByRouteId(int id) throws SQLException {
        return new RouteStopPointDAOImpl().findByRouteId(id);
    }

}
