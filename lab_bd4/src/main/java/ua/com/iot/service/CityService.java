package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.CityDAOImpl;
import ua.com.iot.model.City;
import java.sql.SQLException;
import java.util.List;

public class CityService {
    public List<City> findAll() throws SQLException {
        return new CityDAOImpl().findAll();
    }

    public City findById(Integer id) throws SQLException {
        return new CityDAOImpl().findById(id);
    }

    public int create(City entity) throws SQLException {
        return new CityDAOImpl().create(entity);
    }

    public int update(City entity) throws SQLException {
        return new CityDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new CityDAOImpl().delete(id);
    }

    public List<City> findByName(String name) throws SQLException {
        return new CityDAOImpl().findByCityName(name);
    }
}
