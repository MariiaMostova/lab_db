package ua.com.iot.service;

import ua.com.iot.DAO.implmentetion.RoomTypeDAOImpl;
import ua.com.iot.model.RoomType;

import java.sql.SQLException;
import java.util.List;

public class RoomTypeService {

    public List<RoomType> findAll() throws SQLException {
        return new RoomTypeDAOImpl().findAll();
    }

    public RoomType findById(Integer id) throws SQLException {
        return new RoomTypeDAOImpl().findById(id);
    }

    public int create(RoomType entity) throws SQLException {
        return new RoomTypeDAOImpl().create(entity);
    }

    public int update(RoomType entity) throws SQLException {
        return new RoomTypeDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new RoomTypeDAOImpl().delete(id);
    }

    public List<RoomType> findByName(String name) throws SQLException {
        return new RoomTypeDAOImpl().findByRoomTypeName(name);
    }

    public List<RoomType> findByPersonAmount(int amount) throws SQLException {
        return new RoomTypeDAOImpl().findByPerson(amount);
    }

}
