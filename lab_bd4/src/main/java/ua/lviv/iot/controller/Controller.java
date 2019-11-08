package ua.lviv.iot.controller;

import org.hibernate.Session;

import java.sql.SQLException;

public interface Controller<T> {
    void create(T entity, Session session) throws SQLException;
    void update(T entity, Session session) throws SQLException;
    void delete(int id, Session session) throws SQLException;
    void select(Session session) throws SQLException;
    void findById(int id, Session session) throws SQLException;
}
