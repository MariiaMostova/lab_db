package ua.com.iot.controller;

import ua.com.iot.model.HotelRoom;

import java.sql.SQLException;

public interface HotelRoomController extends Controller<HotelRoom>{
    void findByHotelRoomTypeId(int id) throws SQLException;
    void findByHotelId(int id) throws SQLException;
}
