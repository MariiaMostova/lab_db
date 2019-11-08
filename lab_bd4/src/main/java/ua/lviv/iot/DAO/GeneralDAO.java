package ua.lviv.iot.DAO;

import org.hibernate.Session;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO <T, Id extends Serializable> {

        public void create(T entity, Session session);

        public void update(T entity, Session session);

        public T findById(Id id, Session session) throws SQLException;

        public void delete(Integer id, Session session);

        public List<T> findAll(Session session);

    }
