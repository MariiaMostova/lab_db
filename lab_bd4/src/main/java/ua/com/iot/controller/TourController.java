package ua.com.iot.controller;

import ua.com.iot.model.Tour;

import java.sql.Date;
import java.sql.SQLException;

public interface TourController extends Controller<Tour>{
    void findByStartDate(Date date) throws SQLException;
    void findByEndDate(Date date) throws SQLException;
    void findByRoutelId(int id) throws SQLException;
    void findByPrice(double price) throws SQLException;
}
