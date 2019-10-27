package ua.com.iot.controller;

import ua.com.iot.model.Guide;

import java.sql.SQLException;

public interface GuideController extends Controller<Guide>{
    void findByName(String name) throws SQLException;
    void findBySex(String sex) throws SQLException;
}
