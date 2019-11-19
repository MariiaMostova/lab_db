package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.CountryDTO;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.exception.ExistCityForContryException;
import ua.lviv.iot.exception.NoSuchCityException;
import ua.lviv.iot.exception.NoSuchCountryException;
import ua.lviv.iot.service.CountryService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping(value = "/api/country")
    public ResponseEntity<List<CountryDTO>> getAllCities() throws NoSuchCountryException, NoSuchCityException {
        List<Country> countryList = countryService.getAllCountry();
        Link link = linkTo(methodOn(ua.lviv.iot.controller.CountryController.class).getAllCities()).withSelfRel();

        List<CountryDTO> citiesDTO = new ArrayList<>();
        for (Country entity : countryList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            CountryDTO dto = new CountryDTO(entity, selfLink);
            citiesDTO.add(dto);
        }
        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/country/{country_id}")
    public ResponseEntity<CountryDTO> getCountry(@PathVariable Integer country_id) throws NoSuchCountryException, NoSuchCityException {
        Country country = countryService.getCountry(country_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.CountryController.class).getCountry(country_id)).withSelfRel();
        CountryDTO countryDTO = new CountryDTO(country, link);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/country/{country_id}")
    public ResponseEntity<CountryDTO> addCountry(@RequestBody Country newCountry) throws NoSuchCountryException, NoSuchCityException {
        countryService.createCountry(newCountry);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.CountryController.class).getCountry(newCountry.getId())).withSelfRel();
        CountryDTO countryDTO = new CountryDTO(newCountry, link);
        return new ResponseEntity<>(countryDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/country/{country_id}")
    public ResponseEntity<CountryDTO> updateCountry(@RequestBody Country ucountry, @PathVariable Integer country_id) throws NoSuchCountryException, NoSuchCityException {
        countryService.updateCountry(ucountry, country_id);
        Country country = countryService.getCountry(country_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.CountryController.class).getCountry(country_id)).withSelfRel();
        CountryDTO countryDTO = new CountryDTO(country, link);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/country/{country_id}")
    public ResponseEntity deleteCountry(@PathVariable Integer country_id) throws NoSuchCountryException, ExistCityForContryException {
        countryService.deleteCountry(country_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
