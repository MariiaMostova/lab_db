package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.CountryDAOImpl;
import ua.com.iot.model.Country;

import java.sql.SQLException;
import java.util.List;

public class CountryService {
    public List<Country> findAll() throws SQLException {
        return new CountryDAOImpl().findAll();
    }

    public Country findById(Integer id) throws SQLException {
        return new CountryDAOImpl().findById(id);
    }

    public int create(Country entity) throws SQLException {
        return new CountryDAOImpl().create(entity);
    }

    public int update(Country entity) throws SQLException {
        return new CountryDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new CountryDAOImpl().delete(id);
    }

    public List<Country> findByName(String name) throws SQLException {
        return new CountryDAOImpl().findByCountryName(name);
    }
}
