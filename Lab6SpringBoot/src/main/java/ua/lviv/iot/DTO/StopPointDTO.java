package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.StopPoint;
import ua.lviv.iot.exception.NoSuchStopPointException;

public class StopPointDTO extends ResourceSupport{
    StopPoint stopPoint;
    public StopPointDTO(StopPoint stopPoint, Link selfLink) throws NoSuchStopPointException {
        this.stopPoint=stopPoint;
        add(selfLink);
    }

    public Integer getStopPointId() {
        return stopPoint.getId(); }

    public String getStopPointDescription() {
        return stopPoint.getDescription();
    }

    public Integer getStopPointCityId() {
        return stopPoint.getCityId();
    }

    public Integer getStopPointHotelId() {
        return stopPoint.getHotelId();
    }
}
