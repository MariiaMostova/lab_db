package ua.lviv.iot.controller.implementetion;

import org.hibernate.Session;
import ua.lviv.iot.controller.HotelController;
import ua.lviv.iot.model.Hotel;
import ua.lviv.iot.service.HotelService;

import java.sql.SQLException;
import java.util.List;

public class HotelControllerImpl implements HotelController {

    @Override
    public void create(Hotel entity, Session session) throws SQLException {
        HotelService HotelService = new HotelService();
        HotelService.create(entity, session);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Hotel entity, Session session) throws SQLException {
        HotelService HotelService = new HotelService();
        HotelService.update(entity, session);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id, Session session) throws SQLException {
        HotelService HotelService = new HotelService();
        HotelService.delete(id, session);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id, Session session) throws SQLException {
        HotelService HotelService = new HotelService();
        Hotel Hotel = HotelService.findById(id, session);
        System.out.println("Element with this id is found.");
        System.out.println(Hotel);
    }

    @Override
    public void select(Session session) throws SQLException {
        HotelService HotelService = new HotelService();
        List<Hotel> cities = HotelService.findAll(session);
        for (Hotel Hotel : cities) {
            System.out.println(Hotel);
        }
    }
}
