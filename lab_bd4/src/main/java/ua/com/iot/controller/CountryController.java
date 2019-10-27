package ua.com.iot.controller;

import ua.com.iot.model.Country;

import java.sql.SQLException;

public interface CountryController extends Controller<Country>{
    void findByName(String name) throws SQLException;
}
