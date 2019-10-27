package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.ClientController;
import ua.com.iot.model.Client;
import ua.com.iot.service.ClientService;

import java.sql.SQLException;
import java.util.List;

public class ClientControllerImpl implements ClientController {

    @Override
    public void create(Client entity) throws SQLException {
        ClientService clientService = new ClientService();
        clientService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Client entity) throws SQLException {
        ClientService clientService = new ClientService();
        clientService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        ClientService clientService = new ClientService();
        clientService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
        ClientService clientService = new ClientService();
        Client client = clientService.findById(id);
        System.out.println("Element with this id is found.");
        System.out.println(client);
    }

    @Override
    public void select() throws SQLException {
        ClientService clientService = new ClientService();
        List<Client> list = clientService.findAll();
        for (Client client : list) {
            System.out.println(client);
        }
    }

    @Override
    public void findByName(String name) throws SQLException {
        ClientService clientService = new ClientService();
        List<Client> clients = clientService.findByName(name);
        System.out.println("Element with this name is found.");
        for (Client client : clients) {
            System.out.println(client);
        }
    }
}
