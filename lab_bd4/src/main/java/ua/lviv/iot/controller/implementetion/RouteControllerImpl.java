package ua.lviv.iot.controller.implementetion;

import org.hibernate.Session;
import ua.lviv.iot.controller.RouteCotroller;
import ua.lviv.iot.model.Route;
import ua.lviv.iot.service.RouteService;

import java.sql.SQLException;
import java.util.List;

public class RouteControllerImpl implements RouteCotroller {

    @Override
    public void create(Route entity, Session session) throws SQLException {
        RouteService RouteService = new RouteService();
        RouteService.create(entity, session);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Route entity, Session session) throws SQLException {
        RouteService RouteService = new RouteService();
        RouteService.update(entity, session);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id, Session session) throws SQLException {
        RouteService RouteService = new RouteService();
        RouteService.delete(id, session);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id, Session session) throws SQLException {
        RouteService RouteService = new RouteService();
        Route Route = RouteService.findById(id, session);
        System.out.println("Element with this id is found.");
        System.out.println(Route);
    }

    @Override
    public void select(Session session) throws SQLException {
        RouteService RouteService = new RouteService();
        List<Route> cities = RouteService.findAll(session);
        for (Route Route : cities) {
            System.out.println(Route);
        }
    }
}