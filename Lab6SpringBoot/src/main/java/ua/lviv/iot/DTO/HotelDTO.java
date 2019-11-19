package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.Hotel;
import ua.lviv.iot.exception.NoSuchHotelException;

public class HotelDTO extends ResourceSupport{
    Hotel hotel;
    public HotelDTO(Hotel hotel, Link selfLink) throws NoSuchHotelException{
        this.hotel=hotel;
        add(selfLink);
    }

    public Integer getHotelId() {
        return hotel.getId(); }

    public String getHotelName() {
        return hotel.getName();
    }

    public Integer getHotelCityId() {
        return hotel.getCityId();
    }

}