package pl.com.washme.servicetype.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.com.washme.common.model.Mapper;
import pl.com.washme.common.model.ResultPage;
import pl.com.washme.common.web.UriBuilder;
import pl.com.washme.servicetype.dto.ServiceTypeDto;
import pl.com.washme.servicetype.dto.ServiceTypePageDto;
import pl.com.washme.servicetype.entity.ServiceType;
import pl.com.washme.servicetype.service.ServiceTypeService;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@Api(description = "ServiceTypes resource")
@RequestMapping(value = UriBuilder.PREFIX + "/service-type")
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
    public ResponseEntity addServiceType(@ApiParam(name = "service-type") @RequestBody ServiceTypeDto serviceTypeDto) {
        ServiceType serviceType = mapper.map(serviceTypeDto, ServiceType.class);
        serviceTypeService.addEditServiceType(serviceType);
        URI uri = uriBuilder.requestUriWithId(serviceType.getId());
        return created(uri).build();
    }
    @ApiOperation(value = "Get all ServiceTypes", response = ServiceTypePageDto.class)
    @RequestMapping(method = RequestMethod.GET)
    public ServiceTypePageDto getAllServiceTypes(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "10", name = "pageSize") int pageSize) {
        ResultPage<ServiceType> resultPage = serviceTypeService.getAllServiceTypes(pageNumber, pageSize);
        List<ServiceTypeDto> serviceTypeDtos = mapper.map(resultPage.getContent(), ServiceTypeDto.class);
        return new ServiceTypePageDto(serviceTypeDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
    }
    @ApiOperation(value = "Edit ServiceType")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity editServiceType(@ApiParam(name = "service-type") @RequestBody ServiceTypeDto serviceTypeDto) {
        ServiceType serviceType = mapper.map(serviceTypeDto, ServiceType.class);
        serviceTypeService.addEditServiceType(serviceType);
        URI uri = uriBuilder.requestUriWithId(serviceType.getId());
        return created(uri).build();
    }
    @ApiOperation(value = "Delete ServiceType")
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteServiceType(@ApiParam(name = "service-type") @RequestBody ServiceTypeDto serviceTypeDto) {
        ServiceType serviceType = mapper.map(serviceTypeDto, ServiceType.class);
        serviceTypeService.deleteServiceType(serviceType);
        URI uri = uriBuilder.requestUriWithId(serviceType.getId());
        return created(uri).build();
    }
}
