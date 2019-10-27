package ua.com.iot.controller;

import ua.com.iot.model.Route;

import java.sql.SQLException;

public interface RouteCotroller extends Controller<Route>{
    void findByRoomTypeId(int id) throws SQLException;
}
