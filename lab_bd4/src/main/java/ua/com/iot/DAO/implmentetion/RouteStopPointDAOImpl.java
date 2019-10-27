package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.RouteStopPointDAO;
import ua.com.iot.model.RouteStopPoint;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteStopPointDAOImpl implements RouteStopPointDAO {

    private static final String FIND_ALL = "SELECT * FROM route_stop_point";
    private static final String DELETE = "DELETE FROM route_stop_point WHERE id=?";
    private static final String CREATE = "INSERT route_stop_point (route_id, stop_point_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE route_stop_point SET route_id=?, stop_point_id=?" +
            " WHERE route_id=?, stop_point_id=?";
    private static final String FIND_BY_ROUTE_ID =
            "SELECT * FROM route_stop_point WHERE route_id=?";
    private static final String FIND_BY_STOP_POINT_ID =
            "SELECT * FROM route_stop_point WHERE stop_point_id=?";

    @Override
    public List<RouteStopPoint> findByRouteId(Integer id) throws SQLException {
        List<RouteStopPoint> routeStopPoints = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_ROUTE_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                RouteStopPoint routeStopPoint = null;
                while (resultSet.next()) {
                    int routeId = resultSet.getInt(1);
                    int stopPointId = resultSet.getInt(2);
                    routeStopPoint = new RouteStopPoint(routeId, stopPointId);
                    routeStopPoints.add(routeStopPoint);
                }
            }
        }
        return routeStopPoints;
    }

    @Override
    public List<RouteStopPoint> findByStopPointId(Integer id) throws SQLException {
        List<RouteStopPoint> routeStopPoints = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_STOP_POINT_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                RouteStopPoint routeStopPoint = null;
                while (resultSet.next()) {
                    int routeId = resultSet.getInt(1);
                    int stopPointId = resultSet.getInt(2);
                    routeStopPoint = new RouteStopPoint(routeId, stopPointId);
                    routeStopPoints.add(routeStopPoint);
                }
            }
        }
        return routeStopPoints;
    }

    @Override
    public List<RouteStopPoint> findAll() throws SQLException {
        List<RouteStopPoint> routeStopPoints = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                RouteStopPoint routeStopPoint = null;
                while (resultSet.next()) {
                    int routeId = resultSet.getInt(1);
                    int stopPointId = resultSet.getInt(2);
                    routeStopPoint = new RouteStopPoint(routeId, stopPointId);
                    routeStopPoints.add(routeStopPoint);
                }
            }
        }
        return routeStopPoints;
    }

    @Override
    public int create(RouteStopPoint routeStopPoint) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,routeStopPoint.getRouteId());
            ps.setInt(2,routeStopPoint.getStopPointId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(RouteStopPoint routeStopPoint) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,routeStopPoint.getRouteId());
            ps.setInt(2,routeStopPoint.getStopPointId());
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
