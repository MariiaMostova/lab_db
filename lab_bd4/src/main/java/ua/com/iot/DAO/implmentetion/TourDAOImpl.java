package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.TourDAO;
import ua.com.iot.model.Tour;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class TourDAOImpl implements TourDAO {
    private static final String FIND_ALL = "SELECT * FROM tour";
    private static final String DELETE = "DELETE FROM tour WHERE id=?";
    private static final String CREATE = "INSERT tour (id, start_date, end_date, route_id, price) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE tour SET start_date=?, end_date=?, route_id=?, price=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM tour WHERE id=?";
    private static final String FIND_BY_START_DATE = "SELECT * FROM tour WHERE start_date=?";
    private static final String FIND_BY_END_DATE ="SELECT * FROM tour WHERE end_date=?";
    private static final String FIND_BY_ROUTE_ID = "SELECT * FROM tour WHERE route_id=?";
    private static final String FIND_BY_PRICE = "SELECT * FROM tour WHERE price=?";

    @Override
    public Tour findById(int id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Tour tour;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                tour = null;
                while (resultSet.next()) {
                    int tourId = resultSet.getInt(1);
                    Date startDate = resultSet.getDate(2);
                    Date endDate = resultSet.getDate(3);
                    int routeId = resultSet.getInt(4);
                    double price = resultSet.getDouble(5);
                    tour = new Tour(tourId, startDate, endDate, routeId, price);
                    break;
                }
            }
        }
        return tour;
    }

    @Override
    public List<Tour> findByStartDate(Date date) throws SQLException {
        List<Tour> hotels = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_START_DATE)) {
            ps.setDate(1, date);
            try (ResultSet resultSet = ps.executeQuery()) {
                Tour tour = null;
                while (resultSet.next()) {
                    int tourId = resultSet.getInt(1);
                    Date startDate = resultSet.getDate(2);
                    Date endDate = resultSet.getDate(3);
                    int routeId = resultSet.getInt(4);
                    double price = resultSet.getDouble(5);
                    tour = new Tour(tourId, startDate, endDate, routeId, price);
                    hotels.add(tour);
                }
            }
        }
        return hotels;
    }

    @Override
    public List<Tour> findByEndDate(Date date) throws SQLException {
        List<Tour> hotels = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_END_DATE)) {
            ps.setDate(1, date);
            try (ResultSet resultSet = ps.executeQuery()) {
                Tour tour = null;
                while (resultSet.next()) {
                    int tourId = resultSet.getInt(1);
                    Date startDate = resultSet.getDate(2);
                    Date endDate = resultSet.getDate(3);
                    int routeId = resultSet.getInt(4);
                    double price = resultSet.getDouble(5);
                    tour = new Tour(tourId, startDate, endDate, routeId, price);
                    hotels.add(tour);
                }
            }
        }
        return hotels;
    }

    @Override
    public List<Tour> findByRoutelId(Integer id) throws SQLException {
        List<Tour> hotels = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_ROUTE_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                Tour tour = null;
                while (resultSet.next()) {
                    int tourId = resultSet.getInt(1);
                    Date startDate = resultSet.getDate(2);
                    Date endDate = resultSet.getDate(3);
                    int routeId = resultSet.getInt(4);
                    double price = resultSet.getDouble(5);
                    tour = new Tour(tourId, startDate, endDate, routeId, price);
                    hotels.add(tour);
                }
            }
        }
        return hotels;
    }

    @Override
    public List<Tour> findByPrice(Double tourPrice) throws SQLException {
        List<Tour> hotels = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_PRICE)) {
            ps.setDouble(1, tourPrice);
            try (ResultSet resultSet = ps.executeQuery()) {
                Tour tour = null;
                while (resultSet.next()) {
                    int tourId = resultSet.getInt(1);
                    Date startDate = resultSet.getDate(2);
                    Date endDate = resultSet.getDate(3);
                    int routeId = resultSet.getInt(4);
                    double price = resultSet.getDouble(5);
                    tour = new Tour(tourId, startDate, endDate, routeId, price);
                    hotels.add(tour);
                }
            }
        }
        return hotels;
    }

    @Override
    public List<Tour> findAll() throws SQLException {
        List<Tour> tours = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    Date startDate = resultSet.getDate(2);
                    Date endDate = resultSet.getDate(3);
                    int routeId = resultSet.getInt(4);
                    double price = resultSet.getDouble(5);
                    Tour tour = new Tour(id, startDate, endDate, routeId, price);
                    tours.add(tour);
                }
            }
        }
        return tours;
    }

    @Override
    public int create(Tour tour) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,tour.getTourId());
            ps.setDate(2, (java.sql.Date) tour.getStartDate());
            ps.setDate(3,(java.sql.Date) tour.getEndDate());
            ps.setInt(4, tour.getRouteId());
            ps.setDouble(5, tour.getPrice());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Tour tour) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setDate(1, (java.sql.Date) tour.getStartDate());
            ps.setDate(2,(java.sql.Date) tour.getEndDate());
            ps.setInt(3, tour.getRouteId());
            ps.setDouble(4, tour.getPrice());
            ps.setInt(5, tour.getTourId());
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
