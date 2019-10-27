package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.HotelDAO;
import ua.com.iot.model.Hotel;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {
    private static final String FIND_ALL = "SELECT * FROM hotel";
    private static final String DELETE = "DELETE FROM hotel WHERE id=?";
    private static final String CREATE = "INSERT hotel (id, name, city_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE hotel SET name=?, city_id=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM hotel WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM hotel WHERE name=?";

    @Override
    public Hotel findById(int hotelId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Hotel hotel;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, hotelId);
            try (ResultSet resultSet = ps.executeQuery()) {
                hotel = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int cityId = resultSet.getInt(3);
                    hotel = new Hotel(id, name, cityId);
                    break;
                }
            }
        }
        return hotel;
    }

    @Override
    public List<Hotel> findByHotelName(String hotelName) throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_NAME)) {
            ps.setString(1, hotelName);
            try (ResultSet resultSet = ps.executeQuery()) {
                Hotel hotel = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int cityId = resultSet.getInt(3);
                    hotel = new Hotel(id, name, cityId);
                    hotels.add(hotel);
                }
            }
        }
        return hotels;
    }

    @Override
    public List<Hotel> findAll() throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int cityId = resultSet.getInt(3);
                    Hotel hotel = new Hotel(id, name, cityId);
                    hotels.add(hotel);
                }
            }
        }
        return hotels;
    }

    @Override
    public int create(Hotel hotel) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,hotel.getHotelId());
            ps.setString(2,hotel.getHotelName());
            ps.setInt(3,hotel.getHotelCityId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Hotel hotel) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,hotel.getHotelName());
            ps.setInt(2,hotel.getHotelCityId());
            ps.setInt(3,hotel.getHotelId());
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
