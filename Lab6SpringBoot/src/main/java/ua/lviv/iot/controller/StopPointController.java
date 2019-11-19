package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.StopPointDTO;
import ua.lviv.iot.domain.StopPoint;
import ua.lviv.iot.exception.NoSuchStopPointException;
import ua.lviv.iot.service.StopPointService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class StopPointController {
    @Autowired
    StopPointService stopPointService;

    @GetMapping(value = "/api/stopPoint")
    public ResponseEntity<List<StopPointDTO>> getAllCities() throws NoSuchStopPointException {
        List<StopPoint> stopPointList = stopPointService.getAllStopPoint();
        Link link = linkTo(methodOn(ua.lviv.iot.controller.StopPointController.class).getAllCities()).withSelfRel();

        List<StopPointDTO> citiesDTO = new ArrayList<>();
        for (StopPoint entity : stopPointList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            StopPointDTO dto = new StopPointDTO(entity, selfLink);
            citiesDTO.add(dto);
        }
        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/stopPoint/{stopPoint_id}")
    public ResponseEntity<StopPointDTO> getStopPoint(@PathVariable Integer stopPoint_id) throws NoSuchStopPointException {
        StopPoint stopPoint = stopPointService.getStopPoint(stopPoint_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.StopPointController.class).getStopPoint(stopPoint_id)).withSelfRel();
        StopPointDTO stopPointDTO = new StopPointDTO(stopPoint, link);
        return new ResponseEntity<>(stopPointDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/stopPoint/{stopPoint_id}")
    public ResponseEntity<StopPointDTO> addStopPoint(@RequestBody StopPoint newStopPoint) throws NoSuchStopPointException {
        stopPointService.createStopPoint(newStopPoint);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.StopPointController.class).getStopPoint(newStopPoint.getId())).withSelfRel();
        StopPointDTO stopPointDTO = new StopPointDTO(newStopPoint, link);
        return new ResponseEntity<>(stopPointDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/stopPoint/{stopPoint_id}")
    public ResponseEntity<StopPointDTO> updateStopPoint(@RequestBody StopPoint ustopPoint, @PathVariable Integer stopPoint_id) throws NoSuchStopPointException {
        stopPointService.updateStopPoint(ustopPoint, stopPoint_id);
        StopPoint stopPoint = stopPointService.getStopPoint(stopPoint_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.StopPointController.class).getStopPoint(stopPoint_id)).withSelfRel();
        StopPointDTO stopPointDTO = new StopPointDTO(stopPoint, link);
        return new ResponseEntity<>(stopPointDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/stopPoint/{stopPoint_id}")
    public ResponseEntity deleteStopPoint(@PathVariable Integer stopPoint_id) throws NoSuchStopPointException {
        stopPointService.deleteStopPoint(stopPoint_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
