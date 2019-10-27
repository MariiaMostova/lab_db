package ua.com.iot.controller;

import ua.com.iot.model.Client;

import java.sql.SQLException;

public interface ClientController extends Controller<Client>{
    void findByName(String name) throws SQLException;
}
