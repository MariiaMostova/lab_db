package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.GuideDAOImpl;
import ua.com.iot.model.Guide;

import java.sql.SQLException;
import java.util.List;

public class GuideService {
    public List<Guide> findAll() throws SQLException {
        return new GuideDAOImpl().findAll();
    }

    public Guide findById(Integer id) throws SQLException {
        return new GuideDAOImpl().findById(id);
    }

    public int create(Guide entity) throws SQLException {
        return new GuideDAOImpl().create(entity);
    }

    public int update(Guide entity) throws SQLException {
        return new GuideDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new GuideDAOImpl().delete(id);
    }

    public List<Guide> findByName(String name) throws SQLException {
        return new GuideDAOImpl().findByName(name);
    }

    public List<Guide> findBySex(String sex) throws SQLException {
        return new GuideDAOImpl().findBySex(sex);
    }
}
