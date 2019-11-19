package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.exception.NoSuchClientException;
import ua.lviv.iot.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client getClient(Integer client_id) throws NoSuchClientException {
        Client client = clientRepository.findById(client_id).get();
        if (client == null) throw new NoSuchClientException();
        return client;
    }

    @Transactional
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Transactional
    public void updateClient(Client uClient, Integer client_id) throws NoSuchClientException {
        Client client = clientRepository.findById(client_id).get();
        if (client == null) throw new NoSuchClientException();
        client.setFirstName(client.getFirstName());
        client.setLastName(client.getLastName());
        client.setBirthday(client.getBirthday());
        clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Integer client_id) throws NoSuchClientException {
        Client client = clientRepository.findById(client_id).get();
        if (client == null) throw new NoSuchClientException();
        clientRepository.delete(client);
    }
}
