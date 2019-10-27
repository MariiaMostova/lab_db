package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.ClientDAOImpl;
import ua.com.iot.model.Client;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    public List<Client> findAll() throws SQLException {
        return new ClientDAOImpl().findAll();
    }

    public Client findById(Integer id) throws SQLException {
        return new ClientDAOImpl().findById(id);
    }

    public int create(Client entity) throws SQLException {
        return new ClientDAOImpl().create(entity);
    }

    public int update(Client entity) throws SQLException {
        return new ClientDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new ClientDAOImpl().delete(id);
    }

    public List<Client> findByName(String name) throws SQLException {
        return new ClientDAOImpl().findByName(name);
    }
}
