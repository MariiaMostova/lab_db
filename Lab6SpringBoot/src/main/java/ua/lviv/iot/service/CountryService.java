package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.exception.ExistCityForContryException;
import ua.lviv.iot.exception.NoSuchCountryException;
import ua.lviv.iot.repository.CountryRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

    public Country getCountry(Integer country_id) throws NoSuchCountryException {
        Country country = countryRepository.findById(country_id).get();
        if (country == null) throw new NoSuchCountryException();
        return country;
    }

    @Transactional
    public void createCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(Country uCountry, Integer country_id) throws NoSuchCountryException {
        Country country = countryRepository.findById(country_id).get();
        if (country == null) throw new NoSuchCountryException();
        country.setName(country.getName());
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(Integer country_id) throws NoSuchCountryException, ExistCityForContryException {
        Country country = countryRepository.findById(country_id).get();
        if (country == null) throw new NoSuchCountryException();
        if (country.getCitiesById().size() != 0) throw new ExistCityForContryException();
        countryRepository.delete(country);
    }

}
