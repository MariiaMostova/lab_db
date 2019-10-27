package ua.com.iot.DAO;

import ua.com.iot.model.RouteType;

import java.sql.SQLException;
import java.util.List;

public interface RouteTypeDAO extends GeneralDAO<RouteType, Integer> {
    RouteType findById(int id) throws SQLException;
    List<RouteType> findByRouteTypeName(String routeTypeName) throws SQLException;
}
