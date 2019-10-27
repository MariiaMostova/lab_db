package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.RouteGuideController;
import ua.com.iot.model.RouteGuide;
import ua.com.iot.service.RouteGuideService;

import java.sql.SQLException;
import java.util.List;

public class RouteGuideControllerImpl implements RouteGuideController {

    @Override
    public void create(RouteGuide entity) throws SQLException {
        RouteGuideService routeGuideService = new RouteGuideService();
        routeGuideService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(RouteGuide entity) throws SQLException {
        RouteGuideService routeGuideService = new RouteGuideService();
        routeGuideService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        RouteGuideService routeGuideService = new RouteGuideService();
        routeGuideService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
        RouteGuideService routeGuideService = new RouteGuideService();
        RouteGuide routeGuide = routeGuideService.findById(id);
        System.out.println("Element with this id is found.");
        System.out.println(routeGuide);
    }

    @Override
    public void select() throws SQLException {
        RouteGuideService routeGuideService = new RouteGuideService();
        List<RouteGuide> list = routeGuideService.findAll();
        for (RouteGuide routeGuide : list) {
            System.out.println(routeGuide);
        }
    }

    @Override
    public void findByGuideId(int id) throws SQLException {
        RouteGuideService routeGuideService = new RouteGuideService();
        List<RouteGuide> list = routeGuideService.findByGuideId(id);
        System.out.println("Element with this name is found.");
        for (RouteGuide routeGuide : list) {
            System.out.println(routeGuide);
        }
    }

    @Override
    public void findByRouteId(int id) throws SQLException {
        RouteGuideService routeGuideService = new RouteGuideService();
        List<RouteGuide> list = routeGuideService.findByRouteId(id);
        System.out.println("Element with this name is found.");
        for (RouteGuide routeGuide : list) {
            System.out.println(routeGuide);
        }
    }
}
