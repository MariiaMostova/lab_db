package ua.com.iot.DAO;

import ua.com.iot.model.StopPoint;

import java.sql.SQLException;
import java.util.List;

public interface StopPointDAO extends GeneralDAO<StopPoint, Integer>{
    StopPoint findById(int id) throws SQLException;
    List<StopPoint> findByStopPointCityId(Integer stopPointCityId) throws SQLException;
    List<StopPoint> findByStopPointHotelId(Integer stopPointHotelId) throws SQLException;
}
