package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.Tour;
import ua.lviv.iot.exception.NoSuchTourException;

import java.sql.Date;

public class TourDTO extends ResourceSupport{
    private Tour tour;
    public TourDTO(Tour tour, Link selfLink) throws NoSuchTourException {
        this.tour=tour;
        add(selfLink);

    }

    public Integer getTourId() {
        return tour.getId(); }

    public Date getTourStartDate() {
        return tour.getStartDate();
    }

    public Date getTourEndDate() {
        return tour.getEndDate();
    }

    public Integer getTourRouteId() {
        return tour.getRouteId(); }

}
