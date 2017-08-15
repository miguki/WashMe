package pl.com.washme.job.controller;

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
import pl.com.washme.job.dto.JobDto;
import pl.com.washme.job.entity.Job;
import pl.com.washme.job.service.JobService;
import pl.com.washme.servicepackage.service.ServicePackageService;
import pl.com.washme.servicetype.entity.ServiceType;
import pl.com.washme.servicetype.service.ServiceTypeService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@Api(description = "Jobs resource")
@RequestMapping(value = UriBuilder.PREFIX + "/jobs")
@RestController
@Transactional
public class JobController {

    @Autowired
    private Mapper mapper;
    @Autowired
    private JobService jobService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private ServicePackageService servicePackageService;
    private UriBuilder uriBuilder = new UriBuilder();

    @ApiOperation(value = "Create new Job")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addServicePackage(@ApiParam(name = "job") @RequestBody JobDto jobDto) {
        Job job = mapper.map(jobDto, Job.class);
        List<ServiceType> serviceTypes = new ArrayList<>();
        List<Long> serviceTypesIds = jobDto.getServiceTypesIds();
        for (Long serviceTypesId : serviceTypesIds) {
            serviceTypes.add(serviceTypeService.findById(serviceTypesId));
        }
        job.setServiceTypes(serviceTypes);
        jobService.addJob(job);
        URI uri = uriBuilder.requestUriWithId(job.getId());
        return created(uri).build();
    }
}
