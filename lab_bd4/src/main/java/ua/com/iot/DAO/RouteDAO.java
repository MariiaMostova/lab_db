package ua.com.iot.DAO;

import ua.com.iot.model.Route;

import java.sql.SQLException;
import java.util.List;

public interface RouteDAO extends GeneralDAO<Route, Integer> {
    Route findById(int id) throws SQLException;
    List<Route> findByRoomTypeId(Integer roomTypeId) throws SQLException;
}
