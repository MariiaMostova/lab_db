package ua.com.iot.controller;

import java.sql.SQLException;
import java.util.List;

public interface Controller<T> {
    void create(T entity) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(int id) throws SQLException;
    void select() throws SQLException;
    void findById(int id) throws SQLException;
}
