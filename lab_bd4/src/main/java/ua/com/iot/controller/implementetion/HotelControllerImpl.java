package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.HotelController;
import ua.com.iot.model.Hotel;
import ua.com.iot.service.HotelService;

import java.sql.SQLException;
import java.util.List;

public class HotelControllerImpl implements HotelController {

    @Override
    public void create(Hotel entity) throws SQLException {
        HotelService hotelService = new HotelService();
        hotelService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Hotel entity) throws SQLException {
        HotelService hotelService = new HotelService();
        hotelService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        HotelService hotelService = new HotelService();
        hotelService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
        HotelService hotelService = new HotelService();
        Hotel hotel = hotelService.findById(id);
        System.out.println("Element with this id is found.");
        System.out.println(hotel);
    }

    @Override
    public void select() throws SQLException {
        HotelService hotelService = new HotelService();
        List<Hotel> list = hotelService.findAll();
        for (Hotel hotel : list) {
            System.out.println(hotel);
        }
    }

    @Override
    public void findByName(String name) throws SQLException {
        HotelService HotelService = new HotelService();
        List<Hotel> list = HotelService.findByName(name);
        System.out.println("Element with this name is found.");
        for (Hotel hotel : list) {
            System.out.println(hotel);
        }
    }
}
