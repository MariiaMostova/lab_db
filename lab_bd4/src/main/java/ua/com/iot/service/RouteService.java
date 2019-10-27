package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.RouteDAOImpl;
import ua.com.iot.model.Route;

import java.sql.SQLException;
import java.util.List;

public class RouteService {

    public List<Route> findAll() throws SQLException {
        return new RouteDAOImpl().findAll();
    }

    public Route findById(Integer id) throws SQLException {
        return new RouteDAOImpl().findById(id);
    }

    public int create(Route entity) throws SQLException {
        return new RouteDAOImpl().create(entity);
    }

    public int update(Route entity) throws SQLException {
        return new RouteDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new RouteDAOImpl().delete(id);
    }
    
    public List<Route> findByRoomTypeId(int id) throws SQLException {
        return new RouteDAOImpl().findByRoomTypeId(id);
    }

}
