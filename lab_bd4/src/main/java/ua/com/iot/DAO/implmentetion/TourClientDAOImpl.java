package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.TourClientDAO;
import ua.com.iot.model.TourClient;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourClientDAOImpl implements TourClientDAO {
    private static final String FIND_ALL = "SELECT * FROM tour_client";
    private static final String DELETE = "DELETE FROM tour_client WHERE id=?";
    private static final String CREATE = "INSERT client_id, tour_id VALUES (?, ?)";
    private static final String UPDATE = "UPDATE tour_client WHERE client_id, tour_id";
    private static final String FIND_BY_CLIENT_ID = "SELECT * FROM tour_client WHERE client_id=?";
    private static final String FIND_BY_TOUR_ID = "SELECT * FROM tour_client WHERE  tour_id=?";


    @Override
    public List<TourClient> findByClientId(Integer id) throws SQLException {
        List<TourClient> tourClients = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_CLIENT_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                TourClient tourClient = null;
                while (resultSet.next()) {
                    int clientId = resultSet.getInt(1);
                    int tourId = resultSet.getInt(2);
                    tourClient = new TourClient(clientId, tourId);
                    tourClients.add(tourClient);
                }
            }
        }
        return tourClients;
    }

    @Override
    public List<TourClient> findByTourId(Integer id) throws SQLException {
        List<TourClient> tourClients = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_TOUR_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                TourClient tourClient = null;
                while (resultSet.next()) {
                    int clientId = resultSet.getInt(1);
                    int tourId = resultSet.getInt(2);
                    tourClient = new TourClient(clientId, tourId);
                    tourClients.add(tourClient);
                }
            }
        }
        return tourClients;
    }

    @Override
    public List<TourClient> findAll() throws SQLException {
        List<TourClient> tourClients = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                TourClient tourClient = null;
                while (resultSet.next()) {
                    int clientId = resultSet.getInt(1);
                    int tourId = resultSet.getInt(2);
                    tourClient = new TourClient(clientId, tourId);
                    tourClients.add(tourClient);
                }
            }
        }
        return tourClients;
    }

    @Override
    public int create(TourClient tourClient) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,tourClient.getClientId());
            ps.setInt(2,tourClient.getTourId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(TourClient tourClient) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,tourClient.getClientId());
            ps.setInt(2,tourClient.getTourId());
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
