package ua.lviv.iot.controller.implementetion;

import org.hibernate.Session;
import ua.lviv.iot.controller.TourController;
import ua.lviv.iot.model.Tour;
import ua.lviv.iot.service.TourService;

import java.sql.SQLException;
import java.util.List;

public class TourControllerImpl implements TourController {

    @Override
    public void create(Tour entity, Session session) throws SQLException {
        TourService TourService = new TourService();
        TourService.create(entity, session);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Tour entity, Session session) throws SQLException {
        TourService TourService = new TourService();
        TourService.update(entity, session);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id, Session session) throws SQLException {
        TourService TourService = new TourService();
        TourService.delete(id, session);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id, Session session) throws SQLException {
        TourService TourService = new TourService();
        Tour Tour = TourService.findById(id, session);
        System.out.println("Element with this id is found.");
        System.out.println(Tour);
    }

    @Override
    public void select(Session session) throws SQLException {
        TourService TourService = new TourService();
        List<Tour> cities = TourService.findAll(session);
        for (Tour Tour : cities) {
            System.out.println(Tour);
        }
    }
}
