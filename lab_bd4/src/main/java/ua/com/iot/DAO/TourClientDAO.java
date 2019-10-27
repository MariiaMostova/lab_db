package ua.com.iot.DAO;

import ua.com.iot.model.TourClient;

import java.sql.SQLException;
import java.util.List;

public interface TourClientDAO extends GeneralDAO<TourClient, Integer> {
    List<TourClient> findByClientId(Integer clientId) throws SQLException;
    List<TourClient> findByTourId(Integer tourId) throws SQLException;
}

