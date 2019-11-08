package ua.lviv.iot.service;

import org.hibernate.Session;
import ua.lviv.iot.DAO.implmentetion.TourDAOImpl;
import ua.lviv.iot.model.Tour;
import java.sql.SQLException;
import java.util.List;

public class TourService {

    public List<Tour> findAll(Session session) throws SQLException {
        return new TourDAOImpl().findAll(session);
    }

    public Tour findById(Integer id, Session session) throws SQLException {
        return new TourDAOImpl().findById(id, session);
    }

    public void create(Tour entity, Session session) throws SQLException {
        new TourDAOImpl().create(entity, session);
    }

    public void update(Tour entity, Session session) throws SQLException {
        new TourDAOImpl().update(entity, session);
    }

    public void delete(Integer id, Session session) throws SQLException {
        new TourDAOImpl().delete(id, session);
    }

}