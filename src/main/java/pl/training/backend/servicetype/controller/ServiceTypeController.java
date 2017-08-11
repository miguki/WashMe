package pl.training.backend.servicetype.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.training.backend.common.model.Mapper;
import pl.training.backend.common.web.UriBuilder;
import pl.training.backend.servicetype.dto.ServiceTypeDto;
import pl.training.backend.servicetype.entity.ServiceType;
import pl.training.backend.servicetype.service.ServiceTypeService;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

@Api(description = "ServiceTypes resource")
@RequestMapping(value = UriBuilder.PREFIX + "/service-types")
@RestController
@Transactional
public class ServiceTypeController {

    @Autowired
    private Mapper mapper;
    @Autowired
    private ServiceTypeService serviceTypeService;
    private UriBuilder uriBuilder = new UriBuilder();

    @ApiOperation(value = "Create new ServiceType")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addServiceType(@ApiParam(name = "service-type") @RequestBody ServiceTypeDto serviceTypeDto) { //w odpowiedzi wysyła http
        ServiceType serviceType = mapper.map(serviceTypeDto, ServiceType.class);
        serviceTypeService.addServiceType(serviceType);
        URI uri = uriBuilder.requestUriWithId(serviceType.getId());
        return created(uri).build();
    }
}
