package ua.lviv.iot.controller.implementetion;

import org.hibernate.Session;
import ua.lviv.iot.controller.StopPointController;
import ua.lviv.iot.model.StopPoint;
import ua.lviv.iot.service.StopPointService;

import java.sql.SQLException;
import java.util.List;

public class StopPointControllerImpl implements StopPointController {

    @Override
    public void create(StopPoint entity, Session session) throws SQLException {
        StopPointService StopPointService = new StopPointService();
        StopPointService.create(entity, session);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(StopPoint entity, Session session) throws SQLException {
        StopPointService StopPointService = new StopPointService();
        StopPointService.update(entity, session);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id, Session session) throws SQLException {
        StopPointService StopPointService = new StopPointService();
        StopPointService.delete(id, session);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id, Session session) throws SQLException {
        StopPointService StopPointService = new StopPointService();
        StopPoint StopPoint = StopPointService.findById(id, session);
        System.out.println("Element with this id is found.");
        System.out.println(StopPoint);
    }

    @Override
    public void select(Session session) throws SQLException {
        StopPointService StopPointService = new StopPointService();
        List<StopPoint> cities = StopPointService.findAll(session);
        for (StopPoint StopPoint : cities) {
            System.out.println(StopPoint);
        }
    }
}

