package ua.com.iot.controller;

import ua.com.iot.model.StopPoint;

import java.sql.SQLException;

public interface StopPointController extends Controller<StopPoint>{
    void findByCityId(int id) throws SQLException;
    void findByHotelId(int id) throws SQLException;
}
