package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.TourDAOImpl;
import ua.com.iot.model.Tour;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class TourService {
    public List<Tour> findAll() throws SQLException {
        return new TourDAOImpl().findAll();
    }

    public Tour findById(Integer id) throws SQLException {
        return new TourDAOImpl().findById(id);
    }

    public int create(Tour entity) throws SQLException {
        return new TourDAOImpl().create(entity);
    }

    public int update(Tour entity) throws SQLException {
        return new TourDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new TourDAOImpl().delete(id);
    }

    public List<Tour> findByStartDate(Date date) throws SQLException {
        return new TourDAOImpl().findByStartDate(date);
    }

    public List<Tour> findByEndDate(Date date) throws SQLException {
        return new TourDAOImpl().findByEndDate(date);
    }

    public List<Tour> findByRoutelId(int id) throws SQLException {
        return new TourDAOImpl().findByRoutelId(id);
    }

    public List<Tour> findByPrice(double price) throws SQLException {
        return new TourDAOImpl().findByPrice(price);
    }
}
