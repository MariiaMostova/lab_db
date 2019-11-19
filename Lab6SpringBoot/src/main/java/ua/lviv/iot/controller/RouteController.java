package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.RouteDTO;
import ua.lviv.iot.domain.Route;
import ua.lviv.iot.exception.ExistRouteForTourException;
import ua.lviv.iot.exception.NoSuchRouteException;
import ua.lviv.iot.service.RouteService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping(value = "/api/route")
    public ResponseEntity<List<RouteDTO>> getAllCities() throws NoSuchRouteException {
        List<Route> routeList = routeService.getAllRoute();
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteController.class).getAllCities()).withSelfRel();

        List<RouteDTO> citiesDTO = new ArrayList<>();
        for (Route entity : routeList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            RouteDTO dto = new RouteDTO(entity, selfLink);
            citiesDTO.add(dto);
        }
        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/route/{route_id}")
    public ResponseEntity<RouteDTO> getRoute(@PathVariable Integer route_id) throws NoSuchRouteException {
        Route route = routeService.getRoute(route_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteController.class).getRoute(route_id)).withSelfRel();
        RouteDTO routeDTO = new RouteDTO(route, link);
        return new ResponseEntity<>(routeDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/route/{route_id}")
    public ResponseEntity<RouteDTO> addRoute(@RequestBody Route newRoute) throws NoSuchRouteException {
        routeService.createRoute(newRoute);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteController.class).getRoute(newRoute.getId())).withSelfRel();
        RouteDTO routeDTO = new RouteDTO(newRoute, link);
        return new ResponseEntity<>(routeDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/route/{route_id}")
    public ResponseEntity<RouteDTO> updateRoute(@RequestBody Route uroute, @PathVariable Integer route_id) throws NoSuchRouteException {
        routeService.updateRoute(uroute, route_id);
        Route route = routeService.getRoute(route_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteController.class).getRoute(route_id)).withSelfRel();
        RouteDTO routeDTO = new RouteDTO(route, link);
        return new ResponseEntity<>(routeDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/route/{route_id}")
    public ResponseEntity deleteRoute(@PathVariable Integer route_id) throws NoSuchRouteException, ExistRouteForTourException {
        routeService.deleteRoute(route_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
