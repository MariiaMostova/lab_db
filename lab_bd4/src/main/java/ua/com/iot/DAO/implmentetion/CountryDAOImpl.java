package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.CountryDAO;
import ua.com.iot.model.Country;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOImpl implements CountryDAO {

    private static final String FIND_ALL = "SELECT * FROM country";
    private static final String DELETE = "DELETE FROM country WHERE id=?";
    private static final String CREATE = "INSERT country (id, name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE country SET name=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM country WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM country WHERE name=?";

    @Override
    public List<Country> findByCountryName(String countryName) throws SQLException {
        List<Country> countries = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_NAME)) {
            ps.setString(1, countryName);
            try (ResultSet resultSet = ps.executeQuery()) {
                Country country = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    country = new Country(id, name);
                    countries.add(country);
                }
            }
        }
        return countries;
    }

    @Override
    public Country findById(Integer countryId) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Country country;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, countryId);
            try (ResultSet resultSet = ps.executeQuery()) {
                country = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    country = new Country(id, name);
                    break;
                }
            }
        }
        return country;
    }

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    Country country = new Country(id, name);
                    countries.add(country);
                }
            }
        }
        return countries;
    }

    @Override
    public int create(Country country) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,country.getCountryId());
            ps.setString(2,country.getCountryName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Country country) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,country.getCountryName());
            ps.setInt(2, country.getCountryId());
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
