package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.RouteDAO;
import ua.com.iot.model.Route;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteDAOImpl implements RouteDAO {
    private static final String FIND_ALL = "SELECT * FROM route";
    private static final String DELETE = "DELETE FROM route WHERE id=?";
    private static final String CREATE = "INSERT route (description, route_type_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE route SET description=?, route_type_id=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM route WHERE id=?";
    private static final String FIND_BY_ROUTE_TYPE = "SELECT * FROM route WHERE route_type_id=?";


    @Override
    public Route findById(int id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Route route;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                route = null;
                while (resultSet.next()) {
                    int routeId = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    int routeTypeId = resultSet.getInt(3);
                    route = new Route(routeId, description, routeTypeId);
                    break;
                }
            }
        }
        return route;
    }

    @Override
    public List<Route> findByRoomTypeId(Integer roomTypeId) throws SQLException {
        List<Route> routes = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        Route route;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ROUTE_TYPE)) {
            ps.setInt(1, roomTypeId);
            try (ResultSet resultSet = ps.executeQuery()) {
                route = null;
                while (resultSet.next()) {
                    int routeId = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    int routeTypeId = resultSet.getInt(3);
                    route = new Route(routeId, description, routeTypeId);
                    routes.add(route);
                }
            }
        }
        return routes;
    }

    @Override
    public List<Route> findAll() throws SQLException {
        List<Route> routes = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        Route route;
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                route = null;
                while (resultSet.next()) {
                    int routeId = resultSet.getInt(1);
                    String description = resultSet.getString(2);
                    int routeTypeId = resultSet.getInt(3);
                    route = new Route(routeId, description, routeTypeId);
                    routes.add(route);
                }
            }
        }
        return routes;
    }

    @Override
    public int create(Route route) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1,route.getDescription());
            ps.setInt(2,route.getRouteTypeId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Route route) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,route.getDescription());
            ps.setInt(2,route.getRouteTypeId());
            ps.setInt(3,route.getRouteTypeId());
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
