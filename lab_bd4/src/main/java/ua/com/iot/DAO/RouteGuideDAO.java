package ua.com.iot.DAO;

import ua.com.iot.model.RouteGuide;

import java.sql.SQLException;
import java.util.List;

public interface RouteGuideDAO extends GeneralDAO<RouteGuide, Integer>{
    RouteGuide findById(int id) throws SQLException;
    List<RouteGuide> findByGuideId(Integer guideId) throws SQLException;
    List<RouteGuide> findByRouteId(Integer routeId) throws SQLException;
}
