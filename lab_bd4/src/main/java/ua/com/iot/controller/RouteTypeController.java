package ua.com.iot.controller;

import ua.com.iot.model.RouteType;

import java.sql.SQLException;

public interface RouteTypeController extends Controller<RouteType>{
    void findByName(String name) throws SQLException;
}
