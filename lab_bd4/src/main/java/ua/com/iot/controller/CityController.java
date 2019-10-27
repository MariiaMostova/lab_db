package ua.com.iot.controller;

import ua.com.iot.model.City;

import java.sql.SQLException;

public interface CityController extends Controller<City>{
    void findByName(String name) throws SQLException;
}
