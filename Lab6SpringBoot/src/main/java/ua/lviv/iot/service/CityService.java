package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.City;
import ua.lviv.iot.exception.ExistHotelForCityException;
import ua.lviv.iot.exception.ExistStopPointForCityException;
import ua.lviv.iot.exception.NoSuchCityException;
import ua.lviv.iot.repository.CityRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCity() {
        return cityRepository.findAll();
    }
    public City getCity(Integer city_id) throws NoSuchCityException {
        City city = cityRepository.findById(city_id).get();
        if (city == null) throw new NoSuchCityException();
        return city;
    }

    @Transactional
    public void createCity(City city) {
        cityRepository.save(city);
    }

    @Transactional
    public void updateCity(City uCity, Integer city_id) throws NoSuchCityException {
        City city = cityRepository.findById(city_id).get();
        if (city == null) throw new NoSuchCityException();
        city.setName(city.getName());
        city.setCountryId(city.getCountryId());
        cityRepository.save(city);
    }

    @Transactional
    public void deleteCity(Integer city_id) throws NoSuchCityException, ExistHotelForCityException, ExistStopPointForCityException {
        City city = cityRepository.findById(city_id).get();
        if (city == null) throw new NoSuchCityException();
        if (city.getHotelsById().size() != 0) throw new ExistHotelForCityException();
        if (city.getStopPointsById().size() != 0) throw new ExistStopPointForCityException();
        cityRepository.delete(city);
    }

}
