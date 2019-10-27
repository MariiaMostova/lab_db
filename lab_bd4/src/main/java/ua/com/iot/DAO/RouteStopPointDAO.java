package ua.com.iot.DAO;

import ua.com.iot.model.RouteGuide;
import ua.com.iot.model.RouteStopPoint;

import java.sql.SQLException;
import java.util.List;

public interface RouteStopPointDAO extends GeneralDAO<RouteStopPoint, Integer> {
    List<RouteStopPoint> findByRouteId(Integer routeId) throws SQLException;
    List<RouteStopPoint> findByStopPointId(Integer stopPointId) throws SQLException;
}
