package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.RouteTypeDAO;
import ua.com.iot.model.RouteType;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteTypeDAOImpl implements RouteTypeDAO {
    private static final String FIND_ALL = "SELECT * FROM route_type";
    private static final String DELETE = "DELETE FROM route_type WHERE id=?";
    private static final String CREATE = "INSERT route_type (id, name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE route_type SET name=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM route_type WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM route_type WHERE name=?";

    @Override
    public RouteType findById(int id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        RouteType routeType;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                routeType = null;
                while (resultSet.next()) {
                    int countryId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    routeType = new RouteType(countryId, name);
                    break;
                }
            }
        }
        return routeType;
    }

    @Override
    public List<RouteType> findByRouteTypeName(String routeTypeName) throws SQLException {
        List<RouteType> routeTypes = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        RouteType routeType;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_NAME)) {
            ps.setString(1, routeTypeName);
            try (ResultSet resultSet = ps.executeQuery()) {
                routeType = null;
                while (resultSet.next()) {
                    int countryId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    routeType = new RouteType(countryId, name);
                    routeTypes.add(routeType);
                }
            }
        }
        return routeTypes;
    }

    @Override
    public List<RouteType> findAll() throws SQLException {
        List<RouteType> routeTypes = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        RouteType routeType;
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                routeType = null;
                while (resultSet.next()) {
                    int countryId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    routeType = new RouteType(countryId, name);
                    routeTypes.add(routeType);
                }
            }
        }
        return routeTypes;
    }

    @Override
    public int create(RouteType routeType) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,routeType.getRouteTypeId());
            ps.setString(2,routeType.getRouteTypeName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(RouteType routeType) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,routeType.getRouteTypeName());
            ps.setInt(2,routeType.getRouteTypeId());
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
