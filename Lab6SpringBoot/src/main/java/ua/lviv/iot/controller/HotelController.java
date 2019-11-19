package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.HotelDTO;
import ua.lviv.iot.domain.Hotel;
import ua.lviv.iot.exception.ExistHotelForStopPointException;
import ua.lviv.iot.exception.NoSuchHotelException;
import ua.lviv.iot.service.HotelService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping(value = "/api/hotel")
    public ResponseEntity<List<HotelDTO>> getAllCities() throws NoSuchHotelException {
        List<Hotel> hotelList = hotelService.getAllHotel();
        Link link = linkTo(methodOn(ua.lviv.iot.controller.HotelController.class).getAllCities()).withSelfRel();

        List<HotelDTO> citiesDTO = new ArrayList<>();
        for (Hotel entity : hotelList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            HotelDTO dto = new HotelDTO(entity, selfLink);
            citiesDTO.add(dto);
        }
        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/hotel/{hotel_id}")
    public ResponseEntity<HotelDTO> getHotel(@PathVariable Integer hotel_id) throws NoSuchHotelException {
        Hotel hotel = hotelService.getHotel(hotel_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.HotelController.class).getHotel(hotel_id)).withSelfRel();
        HotelDTO hotelDTO = new HotelDTO(hotel, link);
        return new ResponseEntity<>(hotelDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/hotel/{hotel_id}")
    public ResponseEntity<HotelDTO> addHotel(@RequestBody Hotel newHotel) throws NoSuchHotelException {
        hotelService.createHotel(newHotel);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.HotelController.class).getHotel(newHotel.getId())).withSelfRel();
        HotelDTO hotelDTO = new HotelDTO(newHotel, link);
        return new ResponseEntity<>(hotelDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/hotel/{hotel_id}")
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody Hotel uhotel, @PathVariable Integer hotel_id) throws NoSuchHotelException {
        hotelService.updateHotel(uhotel, hotel_id);
        Hotel hotel = hotelService.getHotel(hotel_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.HotelController.class).getHotel(hotel_id)).withSelfRel();
        HotelDTO hotelDTO = new HotelDTO(hotel, link);
        return new ResponseEntity<>(hotelDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/hotel/{hotel_id}")
    public ResponseEntity deleteHotel(@PathVariable Integer hotel_id) throws NoSuchHotelException, ExistHotelForStopPointException {
        hotelService.deleteHotel(hotel_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
