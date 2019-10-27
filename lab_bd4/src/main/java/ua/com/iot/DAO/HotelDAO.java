package ua.com.iot.DAO;

import ua.com.iot.model.Hotel;

import java.sql.SQLException;
import java.util.List;

public interface HotelDAO extends GeneralDAO<Hotel, Integer> {
    Hotel findById(int id) throws SQLException;
    List<Hotel> findByHotelName(String hotelName) throws SQLException;
}
