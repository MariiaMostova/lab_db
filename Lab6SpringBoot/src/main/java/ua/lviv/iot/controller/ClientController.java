package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.ClientDTO;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.exception.NoSuchClientException;
import ua.lviv.iot.service.ClientService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping(value = "/api/client")
    public ResponseEntity<List<ClientDTO>> getAllCities() throws NoSuchClientException {
        List<Client> clientList = clientService.getAllClient();
        Link link = linkTo(methodOn(ua.lviv.iot.controller.ClientController.class).getAllCities()).withSelfRel();

        List<ClientDTO> citiesDTO = new ArrayList<>();
        for (Client entity : clientList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            ClientDTO dto = new ClientDTO(entity, selfLink);
            citiesDTO.add(dto);
        }
        return new ResponseEntity<>(citiesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/client/{client_id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Integer client_id) throws NoSuchClientException {
        Client client = clientService.getClient(client_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.ClientController.class).getClient(client_id)).withSelfRel();
        ClientDTO clientDTO = new ClientDTO(client, link);
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/client/{client_id}")
    public ResponseEntity<ClientDTO> addClient(@RequestBody Client newClient) throws NoSuchClientException {
        clientService.createClient(newClient);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.ClientController.class).getClient(newClient.getId())).withSelfRel();
        ClientDTO clientDTO = new ClientDTO(newClient, link);
        return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/client/{client_id}")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody Client uclient, @PathVariable Integer client_id) throws NoSuchClientException {
        clientService.updateClient(uclient, client_id);
        Client client = clientService.getClient(client_id);
        Link link = linkTo(methodOn(ua.lviv.iot.controller.ClientController.class).getClient(client_id)).withSelfRel();
        ClientDTO clientDTO = new ClientDTO(client, link);
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/client/{client_id}")
    public ResponseEntity deleteClient(@PathVariable Integer client_id) throws NoSuchClientException {
        clientService.deleteClient(client_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
