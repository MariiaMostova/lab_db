package ua.lviv.iot.service;

import org.hibernate.Session;
import ua.lviv.iot.DAO.implmentetion.CountryDAOImpl;
import ua.lviv.iot.model.Country;
import java.sql.SQLException;
import java.util.List;

public class CountryService {

    public List<Country> findAll(Session session) throws SQLException {
        return new CountryDAOImpl().findAll(session);
    }

    public Country findById(Integer id, Session session) throws SQLException {
        return new CountryDAOImpl().findById(id, session);
    }

    public void create(Country entity, Session session) throws SQLException {
        new CountryDAOImpl().create(entity, session);
    }

    public void update(Country entity, Session session) throws SQLException {
        new CountryDAOImpl().update(entity, session);
    }

    public void delete(Integer id, Session session) throws SQLException {
        new CountryDAOImpl().delete(id, session);
    }

}