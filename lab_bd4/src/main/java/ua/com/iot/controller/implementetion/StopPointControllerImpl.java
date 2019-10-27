package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.Controller;
import ua.com.iot.controller.StopPointController;
import ua.com.iot.model.StopPoint;
import ua.com.iot.model.StopPoint;
import ua.com.iot.service.StopPointService;

import java.sql.SQLException;
import java.util.List;

public class StopPointControllerImpl implements StopPointController {


    @Override
    public void create(StopPoint entity) throws SQLException {
        StopPointService stopPointService = new StopPointService();
        stopPointService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(StopPoint entity) throws SQLException {
        StopPointService stopPointService = new StopPointService();
        stopPointService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        StopPointService stopPointService = new StopPointService();
        stopPointService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
        StopPointService stopPointService = new StopPointService();
        StopPoint stopPoint = stopPointService.findById(id);
        System.out.println("Element with this id is found.");
        System.out.println(stopPoint);
    }

    @Override
    public void select() throws SQLException {
        StopPointService stopPointService = new StopPointService();
        List<StopPoint> list = stopPointService.findAll();
        for (StopPoint stopPoint : list) {
            System.out.println(stopPoint);
        }
    }

    @Override
    public void findByCityId(int id) throws SQLException {
        StopPointService stopPointService = new StopPointService();
        List<StopPoint> list = stopPointService.findByCityId(id);
        System.out.println("Element with this name is found.");
        for (StopPoint stopPoint : list) {
            System.out.println(stopPoint);
        }
    }

    @Override
    public void findByHotelId(int id) throws SQLException {
        StopPointService stopPointService = new StopPointService();
        List<StopPoint> list = stopPointService.findByHotelId(id);
        System.out.println("Element with this name is found.");
        for (StopPoint stopPoint : list) {
            System.out.println(stopPoint);
        }
    }
}
