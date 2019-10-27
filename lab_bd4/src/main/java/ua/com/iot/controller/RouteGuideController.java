package ua.com.iot.controller;

import ua.com.iot.model.RouteGuide;

import java.sql.SQLException;

public interface RouteGuideController extends Controller<RouteGuide>{
    void findByGuideId(int id) throws SQLException;
    void findByRouteId(int id) throws SQLException;
}
