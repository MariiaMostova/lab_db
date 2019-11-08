package ua.lviv.iot.controller.implementetion;

import org.hibernate.Session;
import ua.lviv.iot.controller.RouteGuideController;
import ua.lviv.iot.model.RouteGuide;
import ua.lviv.iot.service.RouteGuideService;

import java.sql.SQLException;
import java.util.List;

public class RouteGuideControllerImpl implements RouteGuideController {

    @Override
    public void create(RouteGuide entity, Session session) throws SQLException {
        RouteGuideService RouteGuideService = new RouteGuideService();
        RouteGuideService.create(entity, session);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(RouteGuide entity, Session session) throws SQLException {
        RouteGuideService RouteGuideService = new RouteGuideService();
        RouteGuideService.update(entity, session);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id, Session session) throws SQLException {
        RouteGuideService RouteGuideService = new RouteGuideService();
        RouteGuideService.delete(id, session);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id, Session session) throws SQLException {
        RouteGuideService RouteGuideService = new RouteGuideService();
        RouteGuide RouteGuide = RouteGuideService.findById(id, session);
        System.out.println("Element with this id is found.");
        System.out.println(RouteGuide);
    }

    @Override
    public void select(Session session) throws SQLException {
        RouteGuideService RouteGuideService = new RouteGuideService();
        List<RouteGuide> cities = RouteGuideService.findAll(session);
        for (RouteGuide RouteGuide : cities) {
            System.out.println(RouteGuide);
        }
    }
}

