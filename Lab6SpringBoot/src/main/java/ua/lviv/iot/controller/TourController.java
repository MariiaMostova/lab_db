package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.TourDTO;
import ua.lviv.iot.domain.Tour;
import ua.lviv.iot.exception.NoSuchTourException;
import ua.lviv.iot.service.TourService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class TourController {
    @Autowired
    TourService tourService;

    @GetMapping(value = "/api/tour")
    public ResponseEntity<List<TourDTO>> getAllCities() throws NoSuchTourException {
        List<Tour> tourList = tourService.getAllTour();
        Link link = linkTo(methodOn(ua.lviv.iot.controller.TourController.class).getAllCities()).withSelfRel();

        List<TourDTO> citiesDTO = new ArrayList<>();
        for (Tour entity : tourList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            TourDTO dto = new TourDTO(entity, selfLink);
            citiesDTO.add(dto);
        }
        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/tour/{tour_id}")
    public ResponseEntity<TourDTO> getTour(@PathVariable Integer tour_id) throws NoSuchTourException {
        Tour tour = tourService.getTour(tour_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.TourController.class).getTour(tour_id)).withSelfRel();
        TourDTO tourDTO = new TourDTO(tour, link);
        return new ResponseEntity<>(tourDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/tour/{tour_id}")
    public ResponseEntity<TourDTO> addTour(@RequestBody Tour newTour) throws NoSuchTourException {
        tourService.createTour(newTour);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.TourController.class).getTour(newTour.getId())).withSelfRel();
        TourDTO tourDTO = new TourDTO(newTour, link);
        return new ResponseEntity<>(tourDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/tour/{tour_id}")
    public ResponseEntity<TourDTO> updateTour(@RequestBody Tour utour, @PathVariable Integer tour_id) throws NoSuchTourException {
        tourService.updateTour(utour, tour_id);
        Tour tour = tourService.getTour(tour_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.TourController.class).getTour(tour_id)).withSelfRel();
        TourDTO tourDTO = new TourDTO(tour, link);
        return new ResponseEntity<>(tourDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/tour/{tour_id}")
    public ResponseEntity deleteTour(@PathVariable Integer tour_id) throws NoSuchTourException {
        tourService.deleteTour(tour_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
