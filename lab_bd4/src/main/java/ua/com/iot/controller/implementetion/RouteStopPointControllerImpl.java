package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.RouteStopPointController;
import ua.com.iot.model.RouteStopPoint;
import ua.com.iot.model.StopPoint;
import ua.com.iot.service.RouteStopPointService;

import java.sql.SQLException;
import java.util.List;

public class RouteStopPointControllerImpl implements RouteStopPointController {

    @Override
    public void create(RouteStopPoint entity) throws SQLException {
        RouteStopPointService routeStopPointService = new RouteStopPointService();
        routeStopPointService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(RouteStopPoint entity) throws SQLException {
        RouteStopPointService routeStopPointService = new RouteStopPointService();
        routeStopPointService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        RouteStopPointService routeStopPointService = new RouteStopPointService();
        routeStopPointService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
    }

    @Override
    public void select() throws SQLException {
        RouteStopPointService routeStopPointService = new RouteStopPointService();
        List<RouteStopPoint> list = routeStopPointService.findAll();
        for (RouteStopPoint routeStopPoint : list) {
            System.out.println(routeStopPoint);
        }
    }

    @Override
    public void findByStopPointId(int id) throws SQLException {
        RouteStopPointService routeStopPointService = new RouteStopPointService();
        List<RouteStopPoint> list = routeStopPointService.findByStopPointId(id);
        System.out.println("Element with this name is found.");
        for (RouteStopPoint routeStopPoint : list) {
            System.out.println(routeStopPoint);
        }
    }

    @Override
    public void findByRouteId(int id) throws SQLException {
        RouteStopPointService routeStopPointService = new RouteStopPointService();
        List<RouteStopPoint> list = routeStopPointService.findByRouteId(id);
        System.out.println("Element with this name is found.");
        for (RouteStopPoint routeStopPoint : list) {
            System.out.println(routeStopPoint);
        }
    }
}
