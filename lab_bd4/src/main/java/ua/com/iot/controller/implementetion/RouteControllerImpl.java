package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.RouteCotroller;
import ua.com.iot.model.Route;
import ua.com.iot.service.RouteService;

import java.sql.SQLException;
import java.util.List;

public class RouteControllerImpl implements RouteCotroller {

    @Override
    public void create(Route entity) throws SQLException {
        RouteService routeService = new RouteService();
        routeService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Route entity) throws SQLException {
        RouteService routeService = new RouteService();
        routeService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        RouteService routeService = new RouteService();
        routeService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
        RouteService routeService = new RouteService();
        Route route = routeService.findById(id);
        System.out.println("Element with this id is found.");
        System.out.println(route);
    }

    @Override
    public void select() throws SQLException {
        RouteService routeService = new RouteService();
        List<Route> list = routeService.findAll();
        for (Route route : list) {
            System.out.println(route);
        }
    }

    @Override
    public void findByRoomTypeId(int id) throws SQLException {
        RouteService routeService = new RouteService();
        List<Route> list = routeService.findByRoomTypeId(id);
        System.out.println("Element with this name is found.");
        for (Route route : list) {
            System.out.println(route);
        }
    }
}
