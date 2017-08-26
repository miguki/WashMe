package pl.com.washme.servicepackage.controller;

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
import pl.com.washme.common.model.Mapper;
import pl.com.washme.common.web.UriBuilder;
import pl.com.washme.servicepackage.dto.ServicePackageDto;
import pl.com.washme.servicepackage.entity.ServicePackage;
import pl.com.washme.servicepackage.service.ServicePackageService;
import pl.com.washme.servicetype.entity.ServiceType;
import pl.com.washme.servicetype.service.ServiceTypeService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@Api(description = "ServicePackages resource")
@RequestMapping(value = UriBuilder.PREFIX + "/service-package")
@RestController
@Transactional
public class ServicePackageController {

    @Autowired
    private Mapper mapper;
    @Autowired
    private ServicePackageService servicePackageService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    private UriBuilder uriBuilder = new UriBuilder();

    @ApiOperation(value = "Create new ServicePackage")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addServicePackage(@ApiParam(name = "service-package") @RequestBody ServicePackageDto servicePackageDto) {
        ServicePackage servicePackage = mapper.map(servicePackageDto, ServicePackage.class);
        List<ServiceType> serviceTypes = new ArrayList<>();
        List<Long> serviceTypesIds = servicePackageDto.getServiceTypesIds();
        for (Long serviceTypesId : serviceTypesIds) {
            serviceTypes.add(serviceTypeService.findById(serviceTypesId));
        }
        servicePackage.setServiceTypes(serviceTypes);
        servicePackageService.addServicePackage(servicePackage);
        URI uri = uriBuilder.requestUriWithId(servicePackage.getId());
        return created(uri).build();
    }
}
