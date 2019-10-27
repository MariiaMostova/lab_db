package ua.com.iot.DAO;

import ua.com.iot.model.RoomType;
import java.sql.SQLException;
import java.util.List;

public interface RoomTypeDAO extends  GeneralDAO<RoomType, Integer>{
    RoomType findById(int id) throws SQLException;
    List<RoomType> findByRoomTypeName(String roomTypeName) throws SQLException;
    List<RoomType> findByPerson(Integer personCount) throws SQLException;
}
