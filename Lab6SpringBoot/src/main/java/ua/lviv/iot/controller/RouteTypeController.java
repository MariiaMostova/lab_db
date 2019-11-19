package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.RouteTypeDTO;
import ua.lviv.iot.domain.RouteType;
import ua.lviv.iot.exception.ExistRouteTypeForRouteException;
import ua.lviv.iot.exception.NoSuchRouteTypeException;
import ua.lviv.iot.service.RouteTypeService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class RouteTypeController {
    @Autowired
    RouteTypeService routeTypeService;

    @GetMapping(value = "/api/routeType")
    public ResponseEntity<List<RouteTypeDTO>> getAllCities() throws NoSuchRouteTypeException {
        List<RouteType> routeTypeList = routeTypeService.getAllRouteType();
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteTypeController.class).getAllCities()).withSelfRel();

        List<RouteTypeDTO> citiesDTO = new ArrayList<>();
        for (RouteType entity : routeTypeList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            RouteTypeDTO dto = new RouteTypeDTO(entity, selfLink);
            citiesDTO.add(dto);
        }
        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/routeType/{routeType_id}")
    public ResponseEntity<RouteTypeDTO> getRouteType(@PathVariable Integer routeType_id) throws NoSuchRouteTypeException {
        RouteType routeType = routeTypeService.getRouteType(routeType_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteTypeController.class).getRouteType(routeType_id)).withSelfRel();
        RouteTypeDTO routeTypeDTO = new RouteTypeDTO(routeType, link);
        return new ResponseEntity<>(routeTypeDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/routeType/{routeType_id}")
    public ResponseEntity<RouteTypeDTO> addRouteType(@RequestBody RouteType newRouteType) throws NoSuchRouteTypeException {
        routeTypeService.createRouteType(newRouteType);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteTypeController.class).getRouteType(newRouteType.getId())).withSelfRel();
        RouteTypeDTO routeTypeDTO = new RouteTypeDTO(newRouteType, link);
        return new ResponseEntity<>(routeTypeDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/routeType/{routeType_id}")
    public ResponseEntity<RouteTypeDTO> updateRouteType(@RequestBody RouteType urouteType, @PathVariable Integer routeType_id) throws NoSuchRouteTypeException {
        routeTypeService.updateRouteType(urouteType, routeType_id);
        RouteType routeType = routeTypeService.getRouteType(routeType_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RouteTypeController.class).getRouteType(routeType_id)).withSelfRel();
        RouteTypeDTO routeTypeDTO = new RouteTypeDTO(routeType, link);
        return new ResponseEntity<>(routeTypeDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/routeType/{routeType_id}")
    public ResponseEntity deleteRouteType(@PathVariable Integer routeType_id) throws NoSuchRouteTypeException, ExistRouteTypeForRouteException {
        routeTypeService.deleteRouteType(routeType_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
