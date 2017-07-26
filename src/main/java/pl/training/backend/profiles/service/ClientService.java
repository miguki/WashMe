package pl.training.backend.profiles.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.training.backend.profiles.entity.Client;
import pl.training.backend.profiles.repository.ClientRepository;
import pl.training.backend.security.entity.User;

/**
 * Created by Jasiek on 26.07.2017.
 */
@Data
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void addClient(Client client) {
        clientRepository.saveAndFlush(client);
    }

}
