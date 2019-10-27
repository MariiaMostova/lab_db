package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.HotelDAOImpl;
import ua.com.iot.model.Hotel;

import java.sql.SQLException;
import java.util.List;

public class HotelService {

    public List<Hotel> findAll() throws SQLException {
        return new HotelDAOImpl().findAll();
    }

    public Hotel findById(Integer id) throws SQLException {
        return new HotelDAOImpl().findById(id);
    }

    public int create(Hotel entity) throws SQLException {
        return new HotelDAOImpl().create(entity);
    }

    public int update(Hotel entity) throws SQLException {
        return new HotelDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new HotelDAOImpl().delete(id);
    }

    public List<Hotel> findByName(String name) throws SQLException {
        return new HotelDAOImpl().findByHotelName(name);
    }

}
