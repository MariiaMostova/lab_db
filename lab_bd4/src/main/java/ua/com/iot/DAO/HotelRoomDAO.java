package ua.com.iot.DAO;

import ua.com.iot.model.HotelRoom;

import java.sql.SQLException;
import java.util.List;

public interface HotelRoomDAO extends GeneralDAO<HotelRoom, Integer> {
    List<HotelRoom> findByHotelRoomTypeId(Integer hotelRoomTypeId) throws SQLException;
    List<HotelRoom> findByHotelId(Integer hotelId) throws SQLException;
}
