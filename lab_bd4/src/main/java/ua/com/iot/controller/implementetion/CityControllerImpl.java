package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.CityController;
import ua.com.iot.model.City;
import ua.com.iot.service.CityService;

import java.sql.SQLException;
import java.util.List;

public class CityControllerImpl implements CityController {

    @Override
    public void create(City entity) throws SQLException {
        CityService cityService = new CityService();
        cityService.create(entity);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(City entity) throws SQLException {
        CityService cityService = new CityService();
        cityService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        CityService cityService = new CityService();
        cityService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
        CityService cityService = new CityService();
        City city = cityService.findById(id);
        System.out.println("Element with this id is found.");
        System.out.println(city);
    }

    @Override
    public void select() throws SQLException {
        CityService cityService = new CityService();
        List<City> cities = cityService.findAll();
        for (City city : cities) {
            System.out.println(city);
        }
    }

    @Override
    public void findByName(String name) throws SQLException {
        CityService cityService = new CityService();
        List<City> cities = cityService.findByName(name);
        System.out.println("Element with this name is found.");
        for (City city : cities) {
            System.out.println(city);
        }
    }
}


