package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.Route;
import ua.lviv.iot.exception.NoSuchRouteException;

public class RouteDTO extends ResourceSupport{
    Route route;
    public RouteDTO(Route route, Link selfLink) throws NoSuchRouteException {
        this.route=route;
        add(selfLink);
    }

    public Integer getRouteId() {
        return route.getId(); }

    public String getRouteDescription() {
        return route.getDescription();
    }

    public Integer getRouteRouteTypeId() {
        return route.getRouteTypeId(); }

}
