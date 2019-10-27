package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.StopPointDAOImpl;
import ua.com.iot.model.StopPoint;

import java.sql.SQLException;
import java.util.List;

public class StopPointService {

    public List<StopPoint> findAll() throws SQLException {
        return new StopPointDAOImpl().findAll();
    }

    public StopPoint findById(Integer id) throws SQLException {
        return new StopPointDAOImpl().findById(id);
    }

    public int create(StopPoint entity) throws SQLException {
        return new StopPointDAOImpl().create(entity);
    }

    public int update(StopPoint entity) throws SQLException {
        return new StopPointDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new StopPointDAOImpl().delete(id);
    }

    public List<StopPoint> findByCityId(int id) throws SQLException {
        return new StopPointDAOImpl().findByStopPointCityId(id);
    }

    public List<StopPoint> findByHotelId(int id) throws SQLException {
        return new StopPointDAOImpl().findByStopPointHotelId(id);
    }
}
