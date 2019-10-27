package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.StopPointDAO;
import ua.com.iot.model.Route;
import ua.com.iot.model.StopPoint;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StopPointDAOImpl implements StopPointDAO{
    private static final String DELETE = "DELETE FROM stop_point WHERE id=?";
    private static final String CREATE = "INSERT stop_point (description, city_id, hotel_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE stop_point SET description=?, city_id=?, hotel_id=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM stop_point WHERE id=?";
    private static final String FIND_BY_CITY_ID = "SELECT * FROM stop_point WHERE city_id=?";
    private static final String FIND_BY_HOTEL_ID = "SELECT * FROM stop_point WHERE hotel_id=?";
    private static final String FIND_ALL = "SELECT * FROM stop_point";

    @Override
    public StopPoint findById(int id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        StopPoint stopPoint;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                stopPoint = null;
                while (resultSet.next()) {
                    int stopPointId = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    int cityId = resultSet.getInt(3);
                    int hotelId = resultSet.getInt(4);
                    stopPoint = new StopPoint(stopPointId, description, cityId, hotelId);
                    break;
                }
            }
        }
        return stopPoint;
    }

    @Override
    public List<StopPoint> findByStopPointCityId(Integer id) throws SQLException {
        List<StopPoint> stopPoints = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        StopPoint stopPoint;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_CITY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                stopPoint = null;
                while (resultSet.next()) {
                    int stopPointId = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    int cityId = resultSet.getInt(3);
                    int hotelId = resultSet.getInt(4);
                    stopPoint = new StopPoint(stopPointId, description, cityId, hotelId);
                    stopPoints.add(stopPoint);
                }
            }
        }
        return stopPoints;
    }

    @Override
    public List<StopPoint> findByStopPointHotelId(Integer id) throws SQLException {
        List<StopPoint> stopPoints = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        StopPoint stopPoint;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_HOTEL_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                stopPoint = null;
                while (resultSet.next()) {
                    int stopPointId = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    int cityId = resultSet.getInt(3);
                    int hotelId = resultSet.getInt(4);
                    stopPoint = new StopPoint(stopPointId, description, cityId, hotelId);
                    stopPoints.add(stopPoint);
                }
            }
        }
        return stopPoints;
    }

    @Override
    public List<StopPoint> findAll() throws SQLException {
        List<StopPoint> stopPoints = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        StopPoint stopPoint;
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                stopPoint = null;
                while (resultSet.next()) {
                    int stopPointId = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    int cityId = resultSet.getInt(3);
                    int hotelId = resultSet.getInt(4);
                    stopPoint = new StopPoint(stopPointId, description, cityId, hotelId);
                    stopPoints.add(stopPoint);
                }
            }
        }
        return stopPoints;
    }

    @Override
    public int create(StopPoint stopPoint) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1,stopPoint.getStopPointDescription());
            ps.setInt(2,stopPoint.getStopPointCityId());
            ps.setInt(3,stopPoint.getStopPointHotelId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(StopPoint stopPoint) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,stopPoint.getStopPointDescription());
            ps.setInt(2,stopPoint.getStopPointCityId());
            ps.setInt(3,stopPoint.getStopPointHotelId());
            ps.setInt(4,stopPoint.getStopPointId());
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
