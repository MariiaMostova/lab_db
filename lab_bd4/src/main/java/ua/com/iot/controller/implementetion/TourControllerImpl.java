package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.TourController;
import ua.com.iot.model.Tour;
import ua.com.iot.service.TourService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class TourControllerImpl implements TourController {


    @Override
    public void findByStartDate(Date date) throws SQLException {
        TourService tourService = new TourService();
        List<Tour> list = tourService.findByStartDate(date);
        System.out.println("Element with this name is found.");
        for (Tour tour : list) {
            System.out.println(tour);
        }
    }

    @Override
    public void findByEndDate(Date date) throws SQLException {
        TourService tourService = new TourService();
        List<Tour> list = tourService.findByEndDate(date);
        System.out.println("Element with this name is found.");
        for (Tour tour : list) {
            System.out.println(tour);
        }
    }

    @Override
    public void findByRoutelId(int id) throws SQLException {
        TourService tourService = new TourService();
        List<Tour> list = tourService.findByRoutelId(id);
        System.out.println("Element with this name is found.");
        for (Tour tour : list) {
            System.out.println(tour);
        }
    }

    @Override
    public void findByPrice(double price) throws SQLException {
        TourService tourService = new TourService();
        List<Tour> list = tourService.findByPrice(price);
        System.out.println("Element with this name is found.");
        for (Tour tour : list) {
            System.out.println(tour);
        }
    }

    @Override
    public void create(Tour entity) throws SQLException {
        TourService tourService = new TourService();
        tourService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Tour entity) throws SQLException {
        TourService tourService = new TourService();
        tourService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        TourService tourService = new TourService();
        tourService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
        TourService tourService = new TourService();
        Tour tour = tourService.findById(id);
        System.out.println("Element with this id is found.");
        System.out.println(tour);
    }

    @Override
    public void select() throws SQLException {
        TourService tourService = new TourService();
        List<Tour> list = tourService.findAll();
        for (Tour tour : list) {
            System.out.println(tour);
        }
    }
}
