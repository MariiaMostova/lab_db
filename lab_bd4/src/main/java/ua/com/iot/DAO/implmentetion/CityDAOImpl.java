package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.CityDAO;
import ua.com.iot.model.City;
import ua.com.iot.model.Client;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    private static final String FIND_ALL = "SELECT * FROM city";
    private static final String DELETE = "DELETE FROM city WHERE id=?";
    private static final String CREATE = "INSERT city (name, country_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE city SET name=?, country_id=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM city WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM city WHERE name=?";

    @Override
    public City findById(int id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        City city;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                city = null;
                while (resultSet.next()) {
                    int cityId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int countryId = resultSet.getInt(3);
                    city = new City(cityId, name, countryId);
                    break;
                }
            }
        }
        return city;
    }

    @Override
    public List<City> findByCityName(String cityName) throws SQLException {
        List<City> cities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_NAME)) {
            ps.setString(1, cityName);
            try(ResultSet resultSet = ps.executeQuery()){
                City city = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int countryId = resultSet.getInt(3);
                    city = new City(id, name, countryId);
                    cities.add(city);
                }
            }
        }
        return cities;
    }

    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int countryId = resultSet.getInt(3);
                    City city = new City(id, name, countryId);
                    cities.add(city);
                }
            }
        }
        return cities;
    }

    @Override
    public int create(City city) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1,city.getCityName());
            ps.setInt(2,city.getCityCountryId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(City city) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,city.getCityName());
            ps.setInt(2,city.getCityCountryId());
            ps.setInt(3, city.getCityId());
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
