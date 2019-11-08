package ua.lviv.iot.controller.implementetion;

import org.hibernate.Session;
import ua.lviv.iot.controller.CountryController;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.service.CountryService;

import java.sql.SQLException;
import java.util.List;

public class CountryControllerImpl implements CountryController {

    @Override
    public void create(Country entity, Session session) throws SQLException {
        CountryService CountryService = new CountryService();
        CountryService.create(entity, session);
        System.out.println("Element of data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Country entity, Session session) throws SQLException {
        CountryService CountryService = new CountryService();
        CountryService.update(entity, session);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id, Session session) throws SQLException {
        CountryService CountryService = new CountryService();
        CountryService.delete(id, session);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id, Session session) throws SQLException {
        CountryService CountryService = new CountryService();
        Country Country = CountryService.findById(id, session);
        System.out.println("Element with this id is found.");
        System.out.println(Country);
    }

    @Override
    public void select(Session session) throws SQLException {
        CountryService CountryService = new CountryService();
        List<Country> cities = CountryService.findAll(session);
        for (Country Country : cities) {
            System.out.println(Country);
        }
    }
}