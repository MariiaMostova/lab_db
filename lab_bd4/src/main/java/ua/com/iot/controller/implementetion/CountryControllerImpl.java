package ua.com.iot.controller.implementetion;

import ua.com.iot.controller.CountryController;
import ua.com.iot.model.Country;
import ua.com.iot.service.CountryService;

import java.sql.SQLException;
import java.util.List;

public class CountryControllerImpl implements CountryController {

    @Override
    public void create(Country entity) throws SQLException {
        CountryService countryService = new CountryService();
        countryService.create(entity);
        System.out.println("Data base is created.");
        System.out.println(entity);
    }

    @Override
    public void update(Country entity) throws SQLException {
        CountryService countryService = new CountryService();
        countryService.update(entity);
        System.out.println("Data base is updated.");
        System.out.println(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        CountryService countryService = new CountryService();
        countryService.delete(id);
        System.out.println("Element of data base is deleted.");
    }

    @Override
    public void findById(int id) throws SQLException {
        CountryService countryService = new CountryService();
        Country country = countryService.findById(id);
        System.out.println("Element with this id is found.");
        System.out.println(country);
    }

    @Override
    public void select() throws SQLException {
        CountryService countryService = new CountryService();
        List<Country> list = countryService.findAll();
        for (Country country : list) {
            System.out.println(country);
        }
    }

    @Override
    public void findByName(String name) throws SQLException {
        CountryService countryService = new CountryService();
        List<Country> countries = countryService.findByName(name);
        System.out.println("Element with this name is found.");
        System.out.println(countries);
    }

}
