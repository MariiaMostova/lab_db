package ua.com.iot.controller;

import ua.com.iot.model.RoomType;

import java.sql.SQLException;

public interface RoomTypeController extends Controller<RoomType>{

    void findRoomTypeByName(String name) throws SQLException;
    void findByPerson(int personCount) throws SQLException;
}
