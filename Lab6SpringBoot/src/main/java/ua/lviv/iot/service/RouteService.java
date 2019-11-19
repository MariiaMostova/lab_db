package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Route;
import ua.lviv.iot.exception.ExistRouteForTourException;
import ua.lviv.iot.exception.NoSuchRouteException;
import ua.lviv.iot.repository.RouteRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RouteService {
    @Autowired
    RouteRepository routeRepository;

    public List<Route> getAllRoute() {
        return routeRepository.findAll();
    }

    public Route getRoute(Integer route_id) throws NoSuchRouteException {
        Route route = routeRepository.findById(route_id).get();
        if (route == null) throw new NoSuchRouteException();
        return route;
    }

    @Transactional
    public void createRoute(Route route) {
        routeRepository.save(route);
    }

    @Transactional
    public void updateRoute(Route uRoute, Integer route_id) throws NoSuchRouteException {
        Route route = routeRepository.findById(route_id).get();
        if (route == null) throw new NoSuchRouteException();
        route.setDescription(route.getDescription());
        route.setRouteTypeId(route.getRouteTypeId());
        routeRepository.save(route);
    }

    @Transactional
    public void deleteRoute(Integer route_id) throws NoSuchRouteException, ExistRouteForTourException {
        Route route = routeRepository.findById(route_id).get();
        if (route == null) throw new NoSuchRouteException();
        if (route.getToursById().size() != 0) throw new ExistRouteForTourException();
        routeRepository.delete(route);
    }

}
