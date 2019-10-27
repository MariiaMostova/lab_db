package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.RoomTypeController;
import ua.com.iot.model.RoomType;
import ua.com.iot.service.RoomTypeService;

import java.sql.SQLException;
import java.util.List;

public class RoomTypeControllerImpl implements RoomTypeController {

    @Override
    public void create(RoomType entity) throws SQLException {
        RoomTypeService roomTypeService = new RoomTypeService();
        roomTypeService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(RoomType entity) throws SQLException {
        RoomTypeService roomTypeService = new RoomTypeService();
        roomTypeService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        RoomTypeService roomTypeService = new RoomTypeService();
        roomTypeService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
        RoomTypeService roomTypeService = new RoomTypeService();
        RoomType roomType = roomTypeService.findById(id);
        System.out.println("Element with this id is found.");
        System.out.println(roomType);
    }

    @Override
    public void select() throws SQLException {
        RoomTypeService roomTypeService = new RoomTypeService();
        List<RoomType> list = roomTypeService.findAll();
        for (RoomType roomType : list) {
            System.out.println(roomType);
        }
    }

    @Override
    public void findRoomTypeByName(String name) throws SQLException {
        RoomTypeService roomTypeService = new RoomTypeService();
        List<RoomType> list = roomTypeService.findByName(name);
        System.out.println("Element with this name is found.");
        for (RoomType roomType : list) {
            System.out.println(roomType);
        }
    }

    @Override
    public void findByPerson(int personCount) throws SQLException {
        RoomTypeService roomTypeService = new RoomTypeService();
        List<RoomType> list = roomTypeService.findByPersonAmount(personCount);
        System.out.println("Element with this name is found.");
        for (RoomType roomType : list) {
            System.out.println(roomType);
        }
    }
    
}
