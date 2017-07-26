package pl.training.backend.profiles.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.training.backend.common.model.Mapper;
import pl.training.backend.common.web.UriBuilder;
import pl.training.backend.profiles.dto.ClientDto;
import pl.training.backend.profiles.entity.Client;
import pl.training.backend.profiles.service.ClientService;
import pl.training.backend.security.entity.User;
import pl.training.backend.security.service.UsersService;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

/**
 * Created by Jasiek on 26.07.2017.
 */
@Api(description = "Clients resource")
@RequestMapping(value = UriBuilder.PREFIX + "/clients")
@RestController
public class ClientController {

    @Autowired
    private Mapper mapper;
    @Autowired
    private UsersService usersService;
    @Autowired
    private ClientService clientService;
    private UriBuilder uriBuilder = new UriBuilder();

    @ApiOperation(value = "Create new client")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createClient(@ApiParam(name = "client") @RequestBody ClientDto clientDto) { //w odpowiedzi wysyła http
        User user = mapper.map(clientDto.getUserDto(), User.class);
        usersService.addUser(user);
        Client client = mapper.map(clientDto, Client.class);
        client.setUser(user);
        clientService.addClient(client);
        URI uri = uriBuilder.requestUriWithId(client.getId());
        return created(uri).build();
    }
}
