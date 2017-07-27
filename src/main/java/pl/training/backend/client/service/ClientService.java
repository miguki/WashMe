package pl.training.backend.client.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.training.backend.common.model.ResultPage;
import pl.training.backend.client.entity.Client;
import pl.training.backend.client.repository.ClientRepository;

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

    public ResultPage<Client> getAllClients(int pageNumber, int pageSize) {
        Page<Client> clientsPage = clientRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(clientsPage.getContent(), clientsPage.getNumber(), clientsPage.getTotalPages());
    }

}
