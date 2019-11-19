package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.RouteType;
import ua.lviv.iot.exception.ExistRouteTypeForRouteException;
import ua.lviv.iot.exception.NoSuchRouteTypeException;
import ua.lviv.iot.repository.RouteTypeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RouteTypeService {
    @Autowired
    RouteTypeRepository routeTypeRepository;

    public List<RouteType> getAllRouteType() {
        return routeTypeRepository.findAll();
    }

    public RouteType getRouteType(Integer routeType_id) throws NoSuchRouteTypeException {
        RouteType routeType = routeTypeRepository.findById(routeType_id).get();
        if (routeType == null) throw new NoSuchRouteTypeException();
        return routeType;
    }

    @Transactional
    public void createRouteType(RouteType routeType) {
        routeTypeRepository.save(routeType);
    }

    @Transactional
    public void updateRouteType(RouteType uRouteType, Integer routeType_id) throws NoSuchRouteTypeException {
        RouteType routeType = routeTypeRepository.findById(routeType_id).get();
        if (routeType == null) throw new NoSuchRouteTypeException();
        routeType.setName(routeType.getName());
        routeTypeRepository.save(routeType);
    }

    @Transactional
    public void deleteRouteType(Integer routeType_id) throws NoSuchRouteTypeException, ExistRouteTypeForRouteException {
        RouteType routeType = routeTypeRepository.findById(routeType_id).get();
        if (routeType == null) throw new NoSuchRouteTypeException();
        if (routeType.getRoutesById().size() != 0) throw new ExistRouteTypeForRouteException();
        routeTypeRepository.delete(routeType);
    }

}
