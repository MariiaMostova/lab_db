package ua.lviv.iot.controller.implementetion;

import org.hibernate.Session;
import ua.lviv.iot.controller.RoomTypeController;
import ua.lviv.iot.model.RoomType;
import ua.lviv.iot.service.RoomTypeService;

import java.sql.SQLException;
import java.util.List;

public class RoomTypeControllerImpl implements RoomTypeController {

    @Override
    public void create(RoomType entity, Session session) throws SQLException {
        RoomTypeService RoomTypeService = new RoomTypeService();
        RoomTypeService.create(entity, session);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(RoomType entity, Session session) throws SQLException {
        RoomTypeService RoomTypeService = new RoomTypeService();
        RoomTypeService.update(entity, session);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id, Session session) throws SQLException {
        RoomTypeService RoomTypeService = new RoomTypeService();
        RoomTypeService.delete(id, session);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id, Session session) throws SQLException {
        RoomTypeService RoomTypeService = new RoomTypeService();
        RoomType RoomType = RoomTypeService.findById(id, session);
        System.out.println("Element with this id is found.");
        System.out.println(RoomType);
    }

    @Override
    public void select(Session session) throws SQLException {
        RoomTypeService RoomTypeService = new RoomTypeService();
        List<RoomType> cities = RoomTypeService.findAll(session);
        for (RoomType RoomType : cities) {
            System.out.println(RoomType);
        }
    }
}
