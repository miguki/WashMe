package pl.com.washme.client.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.com.washme.client.dto.ClientsPageDto;
import pl.com.washme.common.web.UriBuilder;
import pl.com.washme.security.dto.UserDto;
import pl.com.washme.security.entity.User;
import pl.com.washme.common.model.Mapper;
import pl.com.washme.common.model.ResultPage;
import pl.com.washme.client.dto.ClientDto;
import pl.com.washme.client.entity.Client;
import pl.com.washme.client.service.ClientService;
import pl.com.washme.security.service.UsersService;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

/**
 * Created by Jasiek on 26.07.2017.
 */
@Api(description = "Clients resource")
@RequestMapping(value = UriBuilder.PREFIX + "/clients")
@RestController
@Transactional
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
    public ResponseEntity createClient(@ApiParam(name = "client") @RequestBody UserDto userDto) { //w odpowiedzi wysyła http
        User user = mapper.map(userDto, User.class);
        Client client = mapper.map(userDto.getClientDto(), Client.class);
        user.setClient(client);
        usersService.addUser(user);
        URI uri = uriBuilder.requestUriWithId(client.getId());
        return created(uri).build();
    }

    @ApiOperation(value = "Get all clients", response = ClientsPageDto.class)
    @RequestMapping(method = RequestMethod.GET)
    public ClientsPageDto getAllClients(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "10", name = "pageSize") int pageSize) {
        ResultPage<Client> resultPage = clientService.getAllClients(pageNumber, pageSize);
        List<ClientDto> clientsDtos = mapper.map(resultPage.getContent(), ClientDto.class);
        return new ClientsPageDto(clientsDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
    }
}
