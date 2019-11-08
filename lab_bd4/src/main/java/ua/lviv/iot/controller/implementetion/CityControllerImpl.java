package ua.lviv.iot.controller.implementetion;

import org.hibernate.Session;
import ua.lviv.iot.controller.CityController;
import ua.lviv.iot.model.City;
import ua.lviv.iot.service.CityService;

import java.sql.SQLException;
import java.util.List;

public class CityControllerImpl implements CityController {

    @Override
    public void create(City entity, Session session) throws SQLException {
        CityService cityService = new CityService();
        cityService.create(entity, session);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(City entity, Session session) throws SQLException {
        CityService cityService = new CityService();
        cityService.update(entity, session);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id, Session session) throws SQLException {
        CityService cityService = new CityService();
        cityService.delete(id, session);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id, Session session) throws SQLException {
        CityService cityService = new CityService();
        City city = cityService.findById(id, session);
        System.out.println("Element with this id is found.");
        System.out.println(city);
    }

    @Override
    public void select(Session session) throws SQLException {
        CityService cityService = new CityService();
        List<City> cities = cityService.findAll(session);
        for (City city : cities) {
            System.out.println(city);
        }
    }
}


