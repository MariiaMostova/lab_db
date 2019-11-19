package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.RouteGuide;
import ua.lviv.iot.exception.NoSuchRouteGuideException;
import ua.lviv.iot.repository.RouteGuideRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RouteGuideService {
    @Autowired
    RouteGuideRepository routeGuideRepository;

    public List<RouteGuide> getAllRouteGuide() {
        return routeGuideRepository.findAll();
    }

    public RouteGuide getRouteGuide(Integer routeGuide_id) throws NoSuchRouteGuideException {
        RouteGuide routeGuide = routeGuideRepository.findById(routeGuide_id).get();
        if (routeGuide == null) throw new NoSuchRouteGuideException();
        return routeGuide;
    }

    @Transactional
    public void createRouteGuide(RouteGuide routeGuide) {
        routeGuideRepository.save(routeGuide);
    }

    @Transactional
    public void updateRouteGuide(RouteGuide uRouteGuide, Integer routeGuide_id) throws NoSuchRouteGuideException {
        RouteGuide routeGuide = routeGuideRepository.findById(routeGuide_id).get();
        if (routeGuide == null) throw new NoSuchRouteGuideException();
        routeGuide.setGuideId(routeGuide.getGuideId());
        routeGuide.setRouteId(routeGuide.getRouteId());
        routeGuide.setStartDate(routeGuide.getStartDate());
        routeGuide.setEndDate(routeGuide.getEndDate());
        routeGuideRepository.save(routeGuide);
    }

    @Transactional
    public void deleteRouteGuide(Integer routeGuide_id) throws NoSuchRouteGuideException {
        RouteGuide routeGuide = routeGuideRepository.findById(routeGuide_id).get();
        if (routeGuide == null) throw new NoSuchRouteGuideException();
        routeGuideRepository.delete(routeGuide);
    }

}
