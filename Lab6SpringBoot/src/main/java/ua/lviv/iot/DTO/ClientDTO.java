package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.exception.NoSuchClientException;

import java.sql.Date;

public class ClientDTO extends ResourceSupport{
    Client client;
    public ClientDTO(Client client, Link selfLink) throws NoSuchClientException {
        this.client=client;
        add(selfLink);
    }

    public Integer getClientId() {
        return client.getId(); }

    public String getClientFirstName() {
        return client.getFirstName();
    }

    public String getClientLastName() {
        return client.getLastName();
    }

    public Date getClientBirthday() {
        return client.getBirthday();
    }

}
