package ua.com.iot.DAO;

import ua.com.iot.model.City;

import java.sql.SQLException;
import java.util.List;

public interface CityDAO extends GeneralDAO<City, Integer>{
    City findById(int id) throws SQLException;
    List<City> findByCityName(String cityName) throws SQLException;
}
