package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.ClientDAO;
import ua.com.iot.model.Client;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    private static final String FIND_ALL = "SELECT * FROM client";
    private static final String DELETE = "DELETE FROM client WHERE id=?";
    private static final String CREATE = "INSERT client (first_name, last_name, birthday) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE client SET first_name=?, last_name=?, birthday=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM client WHERE id=?";
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM client WHERE first_name=?";


    @Override
    public Client findById(int id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Client client;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                client = null;
                while (resultSet.next()) {
                    int clientId = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Date birthday = resultSet.getDate(4);
                    client = new Client(clientId, firstName, lastName, birthday);
                    break;
                }
            }
        }
        return client;
    }

    @Override
    public List<Client> findByName(String clientFirstName) throws SQLException {
        List<Client> clients = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        Client client;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_FIRST_NAME)) {
            ps.setString(1, clientFirstName);
            try (ResultSet resultSet = ps.executeQuery()) {
                client = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Date birthday = resultSet.getDate(4);
                    client = new Client(id, firstName, lastName, birthday);
                    clients.add(client);
                }
            }
        }
        return clients;
    }

    @Override
    public List<Client> findAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_ALL)){
            try(ResultSet resultSet = ps.executeQuery()){
                Client client = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Date birthday = resultSet.getDate(4);
                    client = new Client(id, firstName, lastName, birthday);
                    clients.add(client);
                }
            }
        }
        return clients;
    }

    @Override
    public int create(Client client) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1,client.getClientFirstName());
            ps.setString(2,client.getClientLastName());
            ps.setDate(3, (Date) client.getClientBirthday());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Client client) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,client.getClientFirstName());
            ps.setString(2,client.getClientLastName());
            ps.setDate(3, (Date) client.getClientBirthday());
            ps.setInt(4, client.getClientId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1,id);
            return ps.executeUpdate();
        }
    }
}
