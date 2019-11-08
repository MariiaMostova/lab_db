package ua.lviv.iot.service;

import org.hibernate.Session;
import ua.lviv.iot.DAO.implmentetion.GuideDAOImpl;
import ua.lviv.iot.model.Guide;
import java.sql.SQLException;
import java.util.List;

public class GuideService {

    public List<Guide> findAll(Session session) throws SQLException {
        return new GuideDAOImpl().findAll(session);
    }

    public Guide findById(Integer id, Session session) throws SQLException {
        return new GuideDAOImpl().findById(id, session);
    }

    public void create(Guide entity, Session session) throws SQLException {
        new GuideDAOImpl().create(entity, session);
    }

    public void update(Guide entity, Session session) throws SQLException {
        new GuideDAOImpl().update(entity, session);
    }

    public void delete(Integer id, Session session) throws SQLException {
        new GuideDAOImpl().delete(id, session);
    }

}