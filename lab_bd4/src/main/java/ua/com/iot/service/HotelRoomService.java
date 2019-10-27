package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.HotelRoomDAOImpl;
import ua.com.iot.model.HotelRoom;

import java.sql.SQLException;
import java.util.List;

public class HotelRoomService {

    public List<HotelRoom> findAll() throws SQLException {
        return new HotelRoomDAOImpl().findAll();
    }

    public int create(HotelRoom entity) throws SQLException {
        return new HotelRoomDAOImpl().create(entity);
    }

    public int update(HotelRoom entity) throws SQLException {
        return new HotelRoomDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new HotelRoomDAOImpl().delete(id);
    }

    public List<HotelRoom> findByRoomTypeId(int id) throws SQLException {
        return new HotelRoomDAOImpl().findByHotelRoomTypeId(id);
    }

    public List<HotelRoom> findByHotelId(int id) throws SQLException {
        return new HotelRoomDAOImpl().findByHotelId(id);
    }

}
