package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.HotelRoomController;
import ua.com.iot.model.HotelRoom;
import ua.com.iot.service.HotelRoomService;

import java.sql.SQLException;
import java.util.List;

public class HotelRoomControllerImpl implements HotelRoomController{

    @Override
    public void create(HotelRoom entity) throws SQLException {
        HotelRoomService hotelRoomService = new HotelRoomService();
        hotelRoomService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(HotelRoom entity) throws SQLException {
        HotelRoomService hotelRoomService = new HotelRoomService();
        hotelRoomService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        HotelRoomService hotelRoomService = new HotelRoomService();
        hotelRoomService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
    }

    @Override
    public void select() throws SQLException {
        HotelRoomService hotelRoomService = new HotelRoomService();
        List<HotelRoom> list = hotelRoomService.findAll();
        for (HotelRoom hotelRoom : list) {
            System.out.println(hotelRoom);
        }
    }

    @Override
    public void findByHotelId(int id) throws SQLException {
        HotelRoomService hotelRoomService = new HotelRoomService();
        List<HotelRoom> list = hotelRoomService.findByHotelId( id);
        System.out.println("Element with this name is found.");
        for (HotelRoom hotelRoom : list) {
            System.out.println(hotelRoom);
        }
    }

    @Override
    public void findByHotelRoomTypeId(int id) throws SQLException {
        HotelRoomService HotelRoomService = new HotelRoomService();
        List<HotelRoom> list = HotelRoomService.findByRoomTypeId(id);
        System.out.println("Element with this id is found.");
        for (HotelRoom hotelRoom : list) {
            System.out.println(hotelRoom);
        }
    }
}
