package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.CityDTO;
import ua.lviv.iot.domain.City;
import ua.lviv.iot.exception.ExistHotelForCityException;
import ua.lviv.iot.exception.ExistStopPointForCityException;
import ua.lviv.iot.exception.NoSuchCityException;
import ua.lviv.iot.service.CityService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping(value = "/api/city")
    public ResponseEntity<List<CityDTO>> getAllCities() throws NoSuchCityException {
        List<City> cityList = cityService.getAllCity();
        Link link = linkTo(methodOn(CityController.class).getAllCities()).withSelfRel();
        List<CityDTO> citiesDTO = new ArrayList<>();
        for (City entity : cityList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            CityDTO dto = new CityDTO(entity, selfLink);
            citiesDTO.add(dto);
        }
        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/city/{city_id}")
    public ResponseEntity<CityDTO> getCity(@PathVariable Integer city_id) throws NoSuchCityException {
        City city = cityService.getCity(city_id);
        Link link = linkTo(methodOn(CityController.class).getCity(city_id)).withSelfRel();
        CityDTO cityDTO = new CityDTO(city, link);
        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/city/{city_id}")
    public ResponseEntity<CityDTO> addCity(@RequestBody City newCity) throws NoSuchCityException {
        cityService.createCity(newCity);
        Link link = linkTo(methodOn(CityController.class).getCity(newCity.getId())).withSelfRel();
        CityDTO cityDTO = new CityDTO(newCity, link);
        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/city/{city_id}")
    public ResponseEntity<CityDTO> updateCity(@RequestBody City ucity, @PathVariable Integer city_id) throws NoSuchCityException {
        cityService.updateCity(ucity, city_id);
        City city = cityService.getCity(city_id);
        Link link = linkTo(methodOn(CityController.class).getCity(city_id)).withSelfRel();
        CityDTO cityDTO = new CityDTO(city, link);
        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/city/{city_id}")
    public ResponseEntity deleteCity(@PathVariable Integer city_id) throws NoSuchCityException, ExistStopPointForCityException, ExistHotelForCityException {
        cityService.deleteCity(city_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
