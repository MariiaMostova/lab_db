package ua.com.iot.DAO.implmentetion;

import ua.com.iot.DAO.GuideDAO;
import ua.com.iot.model.Client;
import ua.com.iot.model.Guide;
import ua.com.iot.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuideDAOImpl implements GuideDAO {
    private static final String FIND_ALL = "SELECT * FROM guide";
    private static final String DELETE = "DELETE FROM guide WHERE id=?";
    private static final String CREATE = "INSERT guide (id, first_name, last_name, birthday, sex) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE guide SET first_name=?, last_name=?, birthday=?, sex=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM guide WHERE id=?";
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM guide WHERE first_name=?";
    private static final String FIND_BY_SEX = "SELECT * FROM guide WHERE sex=?";

    @Override
    public List<Guide> findByName(String guideName) throws SQLException {
        List<Guide> guides = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        Guide guide;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_FIRST_NAME)) {
            ps.setString(1, guideName);
            try (ResultSet resultSet = ps.executeQuery()) {
                guide = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Date birthday = resultSet.getDate(4);
                    String sex = resultSet.getString(5);
                    guide = new Guide(id, firstName, lastName, birthday, sex);
                    guides.add(guide);
                }
            }
        }
        return guides;
    }

    @Override
    public List<Guide> findBySex(String guideSex) throws SQLException {
        List<Guide> guides = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_SEX)) {
            ps.setString(1, guideSex);
            try (ResultSet resultSet = ps.executeQuery()) {
                Guide guide = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Date birthday = resultSet.getDate(4);
                    String sex = resultSet.getString(5);
                    guide = new Guide(id, firstName, lastName, birthday, sex);
                    guides.add(guide);
                }
            }
        }
        return guides;
    }

    @Override
    public Guide findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Guide guide;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                guide = null;
                while (resultSet.next()) {
                    int guideId = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Date birthday = resultSet.getDate(4);
                    String sex = resultSet.getString(5);
                    guide = new Guide(guideId, firstName, lastName, birthday, sex);
                    break;
                }
            }
        }
        return guide;
    }

    @Override
    public List<Guide> findAll() throws SQLException {
        List<Guide> guides = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                Guide guide = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Date birthday = resultSet.getDate(4);
                    String sex = resultSet.getString(5);
                    guide = new Guide(id, firstName, lastName, birthday, sex);
                    guides.add(guide);
                }
            }
        }
        return guides;
    }

    @Override
    public int create(Guide guide) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,guide.getGuideId());
            ps.setString(2,guide.getGuideFirstName());
            ps.setString(3,guide.getGuideLastName());
            ps.setDate(4, (java.sql.Date) guide.getGuideBirthday());
            ps.setString(5, guide.getSex());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Guide guide) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,guide.getGuideFirstName());
            ps.setString(2,guide.getGuideLastName());
            ps.setDate(3, (java.sql.Date) guide.getGuideBirthday());
            ps.setString(4, guide.getSex());
            ps.setInt(5,guide.getGuideId());
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
