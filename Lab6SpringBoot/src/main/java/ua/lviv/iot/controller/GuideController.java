package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.GuideDTO;
import ua.lviv.iot.domain.Guide;
import ua.lviv.iot.exception.NoSuchGuideException;
import ua.lviv.iot.service.GuideService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class GuideController {
    @Autowired
    GuideService guideService;

    @GetMapping(value = "/api/guide")
    public ResponseEntity<List<GuideDTO>> getAllCities() throws NoSuchGuideException {
        List<Guide> guideList = guideService.getAllGuide();
        Link link = linkTo(methodOn(ua.lviv.iot.controller.GuideController.class).getAllCities()).withSelfRel();

        List<GuideDTO> citiesDTO = new ArrayList<>();
        for (Guide entity : guideList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            GuideDTO dto = new GuideDTO(entity, selfLink);
            citiesDTO.add(dto);
        }
        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/guide/{guide_id}")
    public ResponseEntity<GuideDTO> getGuide(@PathVariable Integer guide_id) throws NoSuchGuideException {
        Guide guide = guideService.getGuide(guide_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.GuideController.class).getGuide(guide_id)).withSelfRel();
        GuideDTO guideDTO = new GuideDTO(guide, link);
        return new ResponseEntity<>(guideDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/guide/{guide_id}")
    public ResponseEntity<GuideDTO> addGuide(@RequestBody Guide newGuide) throws NoSuchGuideException {
        guideService.createGuide(newGuide);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.GuideController.class).getGuide(newGuide.getId())).withSelfRel();
        GuideDTO guideDTO = new GuideDTO(newGuide, link);
        return new ResponseEntity<>(guideDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/guide/{guide_id}")
    public ResponseEntity<GuideDTO> updateGuide(@RequestBody Guide uguide, @PathVariable Integer guide_id) throws NoSuchGuideException {
        guideService.updateGuide(uguide, guide_id);
        Guide guide = guideService.getGuide(guide_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.GuideController.class).getGuide(guide_id)).withSelfRel();
        GuideDTO guideDTO = new GuideDTO(guide, link);
        return new ResponseEntity<>(guideDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/guide/{guide_id}")
    public ResponseEntity deleteGuide(@PathVariable Integer guide_id) throws NoSuchGuideException {
        guideService.deleteGuide(guide_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
