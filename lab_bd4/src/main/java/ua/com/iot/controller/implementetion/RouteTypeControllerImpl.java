package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.RouteTypeController;
import ua.com.iot.model.RoomType;
import ua.com.iot.model.RouteType;
import ua.com.iot.service.RouteTypeService;

import java.sql.SQLException;
import java.util.List;

public class RouteTypeControllerImpl implements RouteTypeController{

    @Override
    public void create(RouteType entity) throws SQLException {
        RouteTypeService routeTypeService = new RouteTypeService();
        routeTypeService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(RouteType entity) throws SQLException {
        RouteTypeService routeTypeService = new RouteTypeService();
        routeTypeService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        RouteTypeService routeTypeService = new RouteTypeService();
        routeTypeService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
        RouteTypeService routeTypeService = new RouteTypeService();
        RouteType routeType = routeTypeService.findById(id);
        System.out.println("Element with this id is found.");
        System.out.println(routeType);
    }

    @Override
    public void select() throws SQLException {
        RouteTypeService routeTypeService = new RouteTypeService();
        List<RouteType> list = routeTypeService.findAll();
        for (RouteType routeType : list) {
            System.out.println(routeType);
        }
    }

    @Override
    public void findByName(String name) throws SQLException {
        RouteTypeService routeTypeService = new RouteTypeService();
        List<RouteType> list = routeTypeService.findByName(name);
        System.out.println("Element with this name is found.");
        for (RouteType routeType : list) {
            System.out.println(routeType);
        }
    }
}
