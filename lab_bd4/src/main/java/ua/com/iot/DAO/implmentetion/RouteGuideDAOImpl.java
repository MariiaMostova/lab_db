package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.RouteGuideDAO;
import ua.com.iot.model.RouteGuide;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class RouteGuideDAOImpl implements RouteGuideDAO {
    private static final String FIND_ALL = "SELECT * FROM route_guide";
    private static final String DELETE = "DELETE FROM route_guide WHERE id=?";
    private static final String CREATE = "INSERT route_guide (guide_id, route_id, start_date, end_date )" +
            " VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE route_guide SET guide_id=?, route_id=?, start_date=?, end_date=?  " +
            "WHERE id=?";
    private static final String FIND_BY_ID =
            "SELECT * FROM route_guide WHERE id=?";
    private static final String FIND_BY_GUIDE_ID =
            "SELECT * FROM hotel_room WHERE guide_id=?";
    private static final String FIND_BY_ROUTE_ID =
            "SELECT * FROM hotel_room WHERE route_id=?";

    @Override
    public RouteGuide findById(int id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        RouteGuide hotelRoom;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                hotelRoom = null;
                while (resultSet.next()) {
                    int routeGuideId = resultSet.getInt(1);
                    int guideId = resultSet.getInt(2);
                    int routeId = resultSet.getInt(3);
                    Date startDate = resultSet.getDate(4);
                    Date endDate = resultSet.getDate(5);
                    hotelRoom = new RouteGuide(routeGuideId, guideId, routeId, startDate, endDate);
                }
            }
        }
        return hotelRoom;
    }

    @Override
    public List<RouteGuide> findByGuideId(Integer id) throws SQLException {
        List<RouteGuide> hotelRooms = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        RouteGuide hotelRoom;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_GUIDE_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                hotelRoom = null;
                while (resultSet.next()) {
                    int routeGuideId = resultSet.getInt(1);
                    int guideId = resultSet.getInt(2);
                    int routeId = resultSet.getInt(3);
                    Date startDate = resultSet.getDate(4);
                    Date endDate = resultSet.getDate(5);
                    hotelRoom = new RouteGuide(routeGuideId, guideId, routeId, startDate, endDate);
                    hotelRooms.add(hotelRoom);
                }
            }
        }
        return hotelRooms;
    }

    @Override
    public List<RouteGuide> findByRouteId(Integer id) throws SQLException {
        List<RouteGuide> hotelRooms = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        RouteGuide hotelRoom;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ROUTE_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                hotelRoom = null;
                while (resultSet.next()) {
                    int routeGuideId = resultSet.getInt(1);
                    int guideId = resultSet.getInt(2);
                    int routeId = resultSet.getInt(3);
                    Date startDate = resultSet.getDate(4);
                    Date endDate = resultSet.getDate(5);
                    hotelRoom = new RouteGuide(routeGuideId, guideId, routeId, startDate, endDate);
                    hotelRooms.add(hotelRoom);
                }
            }
        }
        return hotelRooms;
    }

    @Override
    public List<RouteGuide> findAll() throws SQLException {
        List<RouteGuide> hotelRooms = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        RouteGuide hotelRoom;
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                hotelRoom = null;
                while (resultSet.next()) {
                    int routeGuideId = resultSet.getInt(1);
                    int guideId = resultSet.getInt(2);
                    int routeId = resultSet.getInt(3);
                    Date startDate = resultSet.getDate(4);
                    Date endDate = resultSet.getDate(5);
                    hotelRoom = new RouteGuide(routeGuideId, guideId, routeId, startDate, endDate);
                    hotelRooms.add(hotelRoom);
                }
            }
        }
        return hotelRooms;
    }

    @Override
    public int create(RouteGuide routeGuide) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,routeGuide.getGuideId());
            ps.setInt(2,routeGuide.getRouteId());
            ps.setDate(3, routeGuide.getStartDate());
            ps.setDate(4, routeGuide.getEndDate());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(RouteGuide routeGuide) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,routeGuide.getGuideId());
            ps.setInt(2,routeGuide.getRouteId());
            ps.setDate(3, routeGuide.getStartDate());
            ps.setDate(4, routeGuide.getEndDate());
            ps.setInt(5,routeGuide.getRouteGuideId());
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
