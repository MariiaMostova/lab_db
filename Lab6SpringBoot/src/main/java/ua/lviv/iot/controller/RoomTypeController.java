package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.RoomTypeDTO;
import ua.lviv.iot.domain.RoomType;
import ua.lviv.iot.exception.NoSuchRoomTypeException;
import ua.lviv.iot.service.RoomTypeService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class RoomTypeController {
    @Autowired
    RoomTypeService roomTypeService;

    @GetMapping(value = "/api/roomType")
    public ResponseEntity<List<RoomTypeDTO>> getAllCities() throws NoSuchRoomTypeException {
        List<RoomType> roomTypeList = roomTypeService.getAllRoomType();
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RoomTypeController.class).getAllCities()).withSelfRel();

        List<RoomTypeDTO> citiesDTO = new ArrayList<>();
        for (RoomType entity : roomTypeList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            RoomTypeDTO dto = new RoomTypeDTO(entity, selfLink);
            citiesDTO.add(dto);
        }
        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/roomType/{roomType_id}")
    public ResponseEntity<RoomTypeDTO> getRoomType(@PathVariable Integer roomType_id) throws NoSuchRoomTypeException {
        RoomType roomType = roomTypeService.getRoomType(roomType_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RoomTypeController.class).getRoomType(roomType_id)).withSelfRel();
        RoomTypeDTO roomTypeDTO = new RoomTypeDTO(roomType, link);
        return new ResponseEntity<>(roomTypeDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/roomType/{roomType_id}")
    public ResponseEntity<RoomTypeDTO> addRoomType(@RequestBody RoomType newRoomType) throws NoSuchRoomTypeException {
        roomTypeService.createRoomType(newRoomType);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RoomTypeController.class).getRoomType(newRoomType.getId())).withSelfRel();
        RoomTypeDTO roomTypeDTO = new RoomTypeDTO(newRoomType, link);
        return new ResponseEntity<>(roomTypeDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/roomType/{roomType_id}")
    public ResponseEntity<RoomTypeDTO> updateRoomType(@RequestBody RoomType uroomType, @PathVariable Integer roomType_id) throws NoSuchRoomTypeException {
        roomTypeService.updateRoomType(uroomType, roomType_id);
        RoomType roomType = roomTypeService.getRoomType(roomType_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.RoomTypeController.class).getRoomType(roomType_id)).withSelfRel();
        RoomTypeDTO roomTypeDTO = new RoomTypeDTO(roomType, link);
        return new ResponseEntity<>(roomTypeDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/roomType/{roomType_id}")
    public ResponseEntity deleteRoomType(@PathVariable Integer roomType_id) throws NoSuchRoomTypeException {
        roomTypeService.deleteRoomType(roomType_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
