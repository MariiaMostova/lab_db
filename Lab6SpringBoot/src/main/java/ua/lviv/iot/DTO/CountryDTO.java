package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.exception.NoSuchCityException;
import ua.lviv.iot.exception.NoSuchCountryException;

public class CountryDTO extends ResourceSupport{
    Country country;
    public CountryDTO(Country country, Link selfLink) throws NoSuchCountryException, NoSuchCityException {
        this.country=country;
        add(selfLink);
//        add(linkTo(methodOn(CityController.class).getCity(country.getId())).withRel("countries"));
    }

    public Integer getCountryId() {
        return country.getId(); }

    public String getCountryName() {
        return country.getName();
    }

}