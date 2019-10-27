package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.TourClientController;
import ua.com.iot.model.TourClient;
import ua.com.iot.service.TourClientService;

import java.sql.SQLException;
import java.util.List;

public class TourClientControllerImpl implements TourClientController {


    @Override
    public void create(TourClient entity) throws SQLException {
        TourClientService tourClientService = new TourClientService();
        tourClientService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(TourClient entity) throws SQLException {
        TourClientService tourClientService = new TourClientService();
        tourClientService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        TourClientService tourClientService = new TourClientService();
        tourClientService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
    }

    @Override
    public void select() throws SQLException {
        TourClientService tourClientService = new TourClientService();
        List<TourClient> list = tourClientService.findAll();
        for (TourClient tourClient : list) {
            System.out.println(tourClient);
        }
    }

    @Override
    public void findByClientId(int id) throws SQLException {
        TourClientService tourClientService = new TourClientService();
        List<TourClient> list = tourClientService.findByClientId( id);
        System.out.println("Element with this name is found.");
        for (TourClient tourClient : list) {
            System.out.println(tourClient);
        }
    }

    @Override
    public void findByTourId(int id) throws SQLException {
        TourClientService tourClientService = new TourClientService();
        List<TourClient> list = tourClientService.findByTourId(id);
        System.out.println("Element with this id is found.");
        for (TourClient tourClient : list) {
            System.out.println(tourClient);
        }
    }
}
