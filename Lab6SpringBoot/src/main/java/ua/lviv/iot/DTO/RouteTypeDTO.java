package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.RouteType;
import ua.lviv.iot.exception.NoSuchRouteTypeException;

public class RouteTypeDTO extends ResourceSupport{
    RouteType routeType;
    public RouteTypeDTO(RouteType routeType, Link selfLink) throws NoSuchRouteTypeException {
        this.routeType=routeType;
        add(selfLink);
    }

    public Integer getRouteTypeId() {
        return routeType.getId();
    }

    public String getRouteTypeName() {
        return routeType.getName();
    }

}
