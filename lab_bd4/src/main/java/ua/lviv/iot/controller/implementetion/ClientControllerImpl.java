package ua.lviv.iot.controller.implementetion;

import org.hibernate.Session;
import ua.lviv.iot.controller.ClientController;
import ua.lviv.iot.model.Client;
import ua.lviv.iot.service.ClientService;

import java.sql.SQLException;
import java.util.List;

public class ClientControllerImpl implements ClientController {

    @Override
    public void create(Client entity, Session session) throws SQLException {
        ClientService ClientService = new ClientService();
        ClientService.create(entity, session);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Client entity, Session session) throws SQLException {
        ClientService ClientService = new ClientService();
        ClientService.update(entity, session);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id, Session session) throws SQLException {
        ClientService ClientService = new ClientService();
        ClientService.delete(id, session);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id, Session session) throws SQLException {
        ClientService ClientService = new ClientService();
        Client Client = ClientService.findById(id, session);
        System.out.println("Element with this id is found.");
        System.out.println(Client);
    }

    @Override
    public void select(Session session) throws SQLException {
        ClientService ClientService = new ClientService();
        List<Client> cities = ClientService.findAll(session);
        for (Client Client : cities) {
            System.out.println(Client);
        }
    }
}