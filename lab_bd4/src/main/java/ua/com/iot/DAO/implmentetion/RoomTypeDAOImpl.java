package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.RoomTypeDAO;
import ua.com.iot.model.RoomType;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAOImpl implements RoomTypeDAO {
    private static final String FIND_ALL = "SELECT * FROM room_type";
    private static final String DELETE = "DELETE FROM room_type WHERE id=?";
    private static final String CREATE = "INSERT room_type (id, name, person) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE room_type SET name=?, person=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM room_type WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM room_type WHERE name=?";
    private static final String FIND_BY_PERSON = "SELECT * FROM room_type WHERE person=?";


    @Override
    public RoomType findById(int id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        RoomType roomType;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                roomType = null;
                while (resultSet.next()) {
                    int roomTypeId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int person = resultSet.getInt(3);
                    roomType = new RoomType(roomTypeId, name, person);
                    break;
                }
            }
        }
        return roomType;
    }

    @Override
    public List<RoomType> findByRoomTypeName(String roomTypeName) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        RoomType roomType;
        List<RoomType> roomTypes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_NAME)) {
            ps.setString(1, roomTypeName);
            try (ResultSet resultSet = ps.executeQuery()) {
                roomType = null;
                while (resultSet.next()) {
                    int roomTypeId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int person = resultSet.getInt(3);
                    roomType = new RoomType(roomTypeId, name, person);
                    roomTypes.add(roomType);
                }
            }
        }
        return roomTypes;
    }

    @Override
    public List<RoomType> findByPerson(Integer personCount) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        RoomType roomType;
        List<RoomType> roomTypes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_PERSON)) {
            ps.setInt(1, personCount);
            try (ResultSet resultSet = ps.executeQuery()) {
                roomType = null;
                while (resultSet.next()) {
                    int roomTypeId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int person = resultSet.getInt(3);
                    roomType = new RoomType(roomTypeId, name, person);
                    roomTypes.add(roomType);
                }
            }
        }
        return roomTypes;
    }

    @Override
    public List<RoomType> findAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        RoomType roomType;
        List<RoomType> roomTypes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                roomType = null;
                while (resultSet.next()) {
                    int roomTypeId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int person = resultSet.getInt(3);
                    roomType = new RoomType(roomTypeId, name, person);
                    roomTypes.add(roomType);
                }
            }
        }
        return roomTypes;
    }

    @Override
    public int create(RoomType roomType) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,roomType.getRoomTypeId());
            ps.setString(2,roomType.getRoomTypeName());
            ps.setInt(3,roomType.getPerson());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(RoomType roomType) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,roomType.getRoomTypeName());
            ps.setInt(2,roomType.getPerson());
            ps.setInt(1,roomType.getRoomTypeId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1,id);
            return ps.executeUpdate();
        }
    }
}
