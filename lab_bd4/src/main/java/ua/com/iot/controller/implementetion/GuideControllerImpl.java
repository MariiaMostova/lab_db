package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.GuideController;
import ua.com.iot.model.Guide;
import ua.com.iot.service.GuideService;

import java.sql.SQLException;
import java.util.List;

public class GuideControllerImpl implements GuideController {
    
    @Override
    public void create(Guide entity) throws SQLException {
        GuideService guideService = new GuideService();
        guideService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Guide entity) throws SQLException {
        GuideService guideService = new GuideService();
        guideService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        GuideService guideService = new GuideService();
        guideService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
        GuideService guideService = new GuideService();
        Guide guide = guideService.findById(id);
        System.out.println("Element with this id is found.");
        System.out.println(guide);
    }

    @Override
    public void select() throws SQLException {
        GuideService guideService = new GuideService();
        List<Guide> list = guideService.findAll();
        for (Guide guide : list) {
            System.out.println(guide);
        }
    }

    @Override
    public void findByName(String name) throws SQLException {
        GuideService guideService = new GuideService();
        List<Guide> list = guideService.findByName(name);
        System.out.println("Element with this name is found.");
        for (Guide guide : list) {
            System.out.println(guide);
        }
    }

    @Override
    public void findBySex(String sex) throws SQLException {
        GuideService guideService = new GuideService();
        List<Guide> list = guideService.findBySex(sex);
        System.out.println("Element with this sex is found.");
        for (Guide guide : list) {
            System.out.println(guide);
        }
    }
}
