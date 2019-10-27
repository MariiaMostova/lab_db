package ua.com.iot.controller;

import ua.com.iot.model.Hotel;

import java.sql.SQLException;
import java.util.List;

public interface HotelController extends Controller<Hotel>{
    void findByName(String name) throws SQLException;
}
