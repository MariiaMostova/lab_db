package ua.com.iot.controller;

import ua.com.iot.model.TourClient;

import java.sql.SQLException;

public interface TourClientController extends Controller<TourClient>{
    void findByClientId(int id) throws SQLException;
    void findByTourId(int id) throws SQLException;
}
