package ua.lviv.iot.controller.implementetion;

import org.hibernate.Session;
import ua.lviv.iot.controller.RouteTypeController;
import ua.lviv.iot.model.RouteType;
import ua.lviv.iot.service.RouteTypeService;

import java.sql.SQLException;
import java.util.List;

public class RouteTypeControllerImpl implements RouteTypeController {

    @Override
    public void create(RouteType entity, Session session) throws SQLException {
        RouteTypeService RouteTypeService = new RouteTypeService();
        RouteTypeService.create(entity, session);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(RouteType entity, Session session) throws SQLException {
        RouteTypeService RouteTypeService = new RouteTypeService();
        RouteTypeService.update(entity, session);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id, Session session) throws SQLException {
        RouteTypeService RouteTypeService = new RouteTypeService();
        RouteTypeService.delete(id, session);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id, Session session) throws SQLException {
        RouteTypeService RouteTypeService = new RouteTypeService();
        RouteType RouteType = RouteTypeService.findById(id, session);
        System.out.println("Element with this id is found.");
        System.out.println(RouteType);
    }

    @Override
    public void select(Session session) throws SQLException {
        RouteTypeService RouteTypeService = new RouteTypeService();
        List<RouteType> cities = RouteTypeService.findAll(session);
        for (RouteType RouteType : cities) {
            System.out.println(RouteType);
        }
    }
}
