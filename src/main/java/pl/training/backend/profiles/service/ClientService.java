package pl.training.backend.profiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.training.backend.profiles.entity.Client;
import pl.training.backend.profiles.repository.ClientRepository;
import pl.training.backend.security.entity.User;

/**
 * Created by Jasiek on 26.07.2017.
 */
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void addClient(Client client) {
        clientRepository.saveAndFlush(client);
    }

}
