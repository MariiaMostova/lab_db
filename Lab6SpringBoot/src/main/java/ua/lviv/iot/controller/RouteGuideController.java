package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.RouteGuideDTO;
import ua.lviv.iot.domain.RouteGuide;
import ua.lviv.iot.exception.NoSuchRouteGuideException;
import ua.lviv.iot.service.RouteGuideService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class RouteGuideController {
    @Autowired
    RouteGuideService routeGuideService;

    @GetMapping(value = "/api/routeGuide")
    public ResponseEntity<List<RouteGuideDTO>> getAllCities() throws NoSuchRouteGuideException {
        List<RouteGuide> routeGuideList = routeGuideService.getAllRouteGuide();
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteGuideController.class).getAllCities()).withSelfRel();

        List<RouteGuideDTO> citiesDTO = new ArrayList<>();
        for (RouteGuide entity : routeGuideList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            RouteGuideDTO dto = new RouteGuideDTO(entity, selfLink);
            citiesDTO.add(dto);
        }
        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/routeGuide/{routeGuide_id}")
    public ResponseEntity<RouteGuideDTO> getRouteGuide(@PathVariable Integer routeGuide_id) throws NoSuchRouteGuideException {
        RouteGuide routeGuide = routeGuideService.getRouteGuide(routeGuide_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteGuideController.class).getRouteGuide(routeGuide_id)).withSelfRel();
        RouteGuideDTO routeGuideDTO = new RouteGuideDTO(routeGuide, link);
        return new ResponseEntity<>(routeGuideDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/routeGuide/{routeGuide_id}")
    public ResponseEntity<RouteGuideDTO> addRouteGuide(@RequestBody RouteGuide newRouteGuide) throws NoSuchRouteGuideException {
        routeGuideService.createRouteGuide(newRouteGuide);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteGuideController.class).getRouteGuide(newRouteGuide.getId())).withSelfRel();
        RouteGuideDTO routeGuideDTO = new RouteGuideDTO(newRouteGuide, link);
        return new ResponseEntity<>(routeGuideDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/routeGuide/{routeGuide_id}")
    public ResponseEntity<RouteGuideDTO> updateRouteGuide(@RequestBody RouteGuide urouteGuide, @PathVariable Integer routeGuide_id) throws NoSuchRouteGuideException {
        routeGuideService.updateRouteGuide(urouteGuide, routeGuide_id);
        RouteGuide routeGuide = routeGuideService.getRouteGuide(routeGuide_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteGuideController.class).getRouteGuide(routeGuide_id)).withSelfRel();
        RouteGuideDTO routeGuideDTO = new RouteGuideDTO(routeGuide, link);
        return new ResponseEntity<>(routeGuideDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/routeGuide/{routeGuide_id}")
    public ResponseEntity deleteRouteGuide(@PathVariable Integer routeGuide_id) throws NoSuchRouteGuideException {
        routeGuideService.deleteRouteGuide(routeGuide_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
