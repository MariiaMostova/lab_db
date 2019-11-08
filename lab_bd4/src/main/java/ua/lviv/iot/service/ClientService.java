package ua.lviv.iot.service;

import org.hibernate.Session;
import ua.lviv.iot.DAO.implmentetion.ClientDAOImpl;
import ua.lviv.iot.model.Client;
import java.sql.SQLException;
import java.util.List;

public class ClientService {

    public List<Client> findAll(Session session) throws SQLException {
        return new ClientDAOImpl().findAll(session);
    }

    public Client findById(Integer id, Session session) throws SQLException {
        return new ClientDAOImpl().findById(id, session);
    }

    public void create(Client entity, Session session) throws SQLException {
        new ClientDAOImpl().create(entity, session);
    }

    public void update(Client entity, Session session) throws SQLException {
        new ClientDAOImpl().update(entity, session);
    }

    public void delete(Integer id, Session session) throws SQLException {
        new ClientDAOImpl().delete(id, session);
    }

}
