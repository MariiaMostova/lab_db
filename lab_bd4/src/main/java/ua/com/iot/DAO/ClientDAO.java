package ua.com.iot.DAO;

import ua.com.iot.model.City;
import ua.com.iot.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO extends GeneralDAO<Client, Integer> {
    Client findById(int id) throws SQLException;
    List<Client> findByName(String name) throws SQLException;
}
