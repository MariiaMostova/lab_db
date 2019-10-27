package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.TourClientDAOImpl;
import ua.com.iot.model.TourClient;

import java.sql.SQLException;
import java.util.List;

public class TourClientService {

    public List<TourClient> findAll() throws SQLException {
        return new TourClientDAOImpl().findAll();
    }

    public int create(TourClient entity) throws SQLException {
        return new TourClientDAOImpl().create(entity);
    }

    public int update(TourClient entity) throws SQLException {
        return new TourClientDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new TourClientDAOImpl().delete(id);
    }

    public List<TourClient> findByClientId(int id) throws SQLException {
        return new TourClientDAOImpl().findByClientId(id);
    }

    public List<TourClient> findByTourId(int id) throws SQLException {
        return new TourClientDAOImpl().findByTourId(id);
    }
}
