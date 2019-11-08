package ua.lviv.iot.service;

import org.hibernate.Session;
import ua.lviv.iot.DAO.implmentetion.CityDAOImpl;
import ua.lviv.iot.model.City;
import java.sql.SQLException;
import java.util.List;

public class CityService {

    public List<City> findAll(Session session) throws SQLException {
        return new CityDAOImpl().findAll(session);
    }

    public City findById(Integer id, Session session) throws SQLException {
        return new CityDAOImpl().findById(id, session);
    }

    public void create(City entity, Session session) throws SQLException {
        new CityDAOImpl().create(entity, session);
    }

    public void update(City entity, Session session) throws SQLException {
        new CityDAOImpl().update(entity, session);
    }

    public void delete(Integer id, Session session) throws SQLException {
        new CityDAOImpl().delete(id, session);
    }

}
