package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.RouteTypeDAOImpl;
import ua.com.iot.model.RouteType;

import java.sql.SQLException;
import java.util.List;

public class RouteTypeService {

    public List<RouteType> findAll() throws SQLException {
        return new RouteTypeDAOImpl().findAll();
    }

    public RouteType findById(Integer id) throws SQLException {
        return new RouteTypeDAOImpl().findById(id);
    }

    public int create(RouteType entity) throws SQLException {
        return new RouteTypeDAOImpl().create(entity);
    }

    public int update(RouteType entity) throws SQLException {
        return new RouteTypeDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new RouteTypeDAOImpl().delete(id);
    }

    public List<RouteType> findByName(String name) throws SQLException {
        return new RouteTypeDAOImpl().findByRouteTypeName(name);
    }

}
