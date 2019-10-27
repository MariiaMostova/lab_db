package ua.com.iot.DAO;

import ua.com.iot.model.Tour;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public interface TourDAO extends GeneralDAO<Tour, Integer> {
    Tour findById(int id) throws SQLException;
    List<Tour> findByStartDate(Date startDate) throws SQLException;
    List<Tour> findByEndDate(Date endDate) throws SQLException;
    List<Tour> findByRoutelId(Integer routeId) throws SQLException;
    List<Tour> findByPrice(Double price) throws SQLException;
}
