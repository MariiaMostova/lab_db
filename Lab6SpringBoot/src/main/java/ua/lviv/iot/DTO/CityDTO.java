package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.City;
import ua.lviv.iot.exception.NoSuchCityException;

public class CityDTO extends ResourceSupport{
    private City city;
    public CityDTO(City city, Link selfLink) throws NoSuchCityException {
        this.city=city;
        add(selfLink);
    }

    public Integer getCityId() {
        return city.getId(); }

    public String getCityName() {
        return city.getName();
    }

    public Integer getCityCountryId() {
        return city.getCountryId();
    }
}
