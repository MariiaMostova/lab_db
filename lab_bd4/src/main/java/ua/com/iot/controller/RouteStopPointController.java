package ua.com.iot.controller;

import ua.com.iot.model.RouteStopPoint;

import java.sql.SQLException;

public interface RouteStopPointController extends Controller<RouteStopPoint>{

    void findByStopPointId(int id) throws SQLException;
    void findByRouteId(int id) throws SQLException;
}
