package ua.lviv.iot.controller.implementetion;

import org.hibernate.Session;
import ua.lviv.iot.controller.GuideController;
import ua.lviv.iot.model.Guide;
import ua.lviv.iot.service.GuideService;

import java.sql.SQLException;
import java.util.List;

public class GuideControllerImpl implements GuideController {

    @Override
    public void create(Guide entity, Session session) throws SQLException {
        GuideService GuideService = new GuideService();
        GuideService.create(entity, session);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Guide entity, Session session) throws SQLException {
        GuideService GuideService = new GuideService();
        GuideService.update(entity, session);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id, Session session) throws SQLException {
        GuideService GuideService = new GuideService();
        GuideService.delete(id, session);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id, Session session) throws SQLException {
        GuideService GuideService = new GuideService();
        Guide Guide = GuideService.findById(id, session);
        System.out.println("Element with this id is found.");
        System.out.println(Guide);
    }

    @Override
    public void select(Session session) throws SQLException {
        GuideService GuideService = new GuideService();
        List<Guide> cities = GuideService.findAll(session);
        for (Guide Guide : cities) {
            System.out.println(Guide);
        }
    }
}
