package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.RouteGuide;
import ua.lviv.iot.exception.NoSuchRouteGuideException;

import java.sql.Date;

public class RouteGuideDTO extends ResourceSupport{
    RouteGuide routeGuide;
    public RouteGuideDTO(RouteGuide routeGuide, Link selfLink) throws NoSuchRouteGuideException{
        this.routeGuide=routeGuide;
        add(selfLink);
    }

    public Integer getRouteGuideId() {
        return routeGuide.getId();
    }

    public Integer getRouteGuideGuideId() {
        return routeGuide.getGuideId();
    }

    public Integer getRouteGuideRouteId() {
        return routeGuide.getRouteId();
    }

    public Date getRouteGuideStartDate() {
        return routeGuide.getStartDate();
    }

    public Date getRouteGuideEndDate() {
        return routeGuide.getEndDate();
    }

}
