package ua.lviv.iot;

import java.sql.SQLException;
import java.text.ParseException;

public interface Printable {
    void print() throws SQLException, ParseException;
}
