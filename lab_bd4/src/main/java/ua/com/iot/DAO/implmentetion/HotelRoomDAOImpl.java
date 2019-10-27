package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.HotelRoomDAO;
import ua.com.iot.model.Hotel;
import ua.com.iot.model.HotelRoom;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelRoomDAOImpl implements HotelRoomDAO {
    private static final String FIND_ALL = "SELECT * FROM hotel_room";
    private static final String DELETE = "DELETE FROM hotel_room WHERE id=?";
    private static final String CREATE = "INSERT hotel_room (hotel_id, room_type_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE hotel_room WHERE room_type_id=?";
    private static final String FIND_BY_HOTEL_ID =
            "SELECT * FROM hotel_room WHERE hotel_id=?";
    private static final String FIND_BY_HOTEL_ROOM_TYPE_ID =
            "SELECT * FROM hotel_room WHERE room_type_id=?";


    @Override
    public List<HotelRoom> findByHotelRoomTypeId(Integer hotelRoomTypeId)
            throws SQLException {
        List<HotelRoom> hotels = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_HOTEL_ROOM_TYPE_ID)) {
            ps.setInt(1, hotelRoomTypeId);
            try (ResultSet resultSet = ps.executeQuery()) {
                HotelRoom hotelRoom = null;
                while (resultSet.next()) {
                    int hotelId = resultSet.getInt(1);
                    int hotelRoomId = resultSet.getInt(2);
                    hotelRoom = new HotelRoom(hotelId, hotelRoomId);
                    hotels.add(hotelRoom);
                }
            }
        }
        return hotels;
    }

    @Override
    public List<HotelRoom> findByHotelId(Integer hotelId) throws SQLException {
        List<HotelRoom> hotels = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_HOTEL_ID)) {
            ps.setInt(1, hotelId);
            try (ResultSet resultSet = ps.executeQuery()) {
                HotelRoom hotelRoom = null;
                while (resultSet.next()) {
                    int hotelRoomId = resultSet.getInt(1);
                    int hotelRoomTypeId = resultSet.getInt(2);
                    hotelRoom = new HotelRoom(hotelRoomId, hotelRoomTypeId);
                    hotels.add(hotelRoom);
                }
            }
        }
        return hotels;
    }

    @Override
    public List<HotelRoom> findAll() throws SQLException {
        List<HotelRoom> hotelRooms = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    int hotelId = resultSet.getInt(1);
                    int hotelRoomTypeId = resultSet.getInt(2);
                    HotelRoom hotelRoom = new HotelRoom(hotelId, hotelRoomTypeId);
                    hotelRooms.add(hotelRoom);
                }
            }
        }
        return hotelRooms;
    }

    @Override
    public int create(HotelRoom hotelRoom) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,hotelRoom.getHotelRoomId());
            ps.setInt(2,hotelRoom.getHotelRoomTypeId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(HotelRoom hotelRoom) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,hotelRoom.getHotelRoomTypeId());
            ps.setInt(2,hotelRoom.getHotelRoomId());
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
