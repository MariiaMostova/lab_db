package ua.com.iot.DAO;

import ua.com.iot.model.Guide;

import java.sql.SQLException;
import java.util.List;

public interface GuideDAO extends GeneralDAO<Guide, Integer> {
    List<Guide> findByName(String name) throws SQLException;
    List<Guide> findBySex(String sex) throws SQLException;
    Guide findById(Integer id) throws SQLException;
}
