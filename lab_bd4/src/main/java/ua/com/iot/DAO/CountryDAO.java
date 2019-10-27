package ua.com.iot.DAO;

import ua.com.iot.model.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryDAO extends GeneralDAO<Country, Integer> {
    List<Country> findByCountryName(String countryName) throws SQLException;
    Country findById(Integer countryId) throws SQLException;
}
