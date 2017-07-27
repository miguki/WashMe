package pl.training.backend.carwash.controller;

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
import pl.training.backend.carwash.dto.CarWashDto;
import pl.training.backend.carwash.entity.CarWash;
import pl.training.backend.carwash.service.CarWashService;
import pl.training.backend.common.model.Mapper;
import pl.training.backend.common.web.UriBuilder;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

/**
 * Created by Jasiek on 27.07.2017.
 */
@Api(description = "Clients resource")
@RequestMapping(value = UriBuilder.PREFIX + "/car-wash")
@RestController
@Transactional
public class CarWashController {

    @Autowired
    private Mapper mapper;
    @Autowired
    private CarWashService carWashService;
    private UriBuilder uriBuilder = new UriBuilder();

    @ApiOperation(value = "Create new car wash")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createCarWash(@ApiParam(name = "car-wash") @RequestBody CarWashDto carWashDto) { //w odpowiedzi wysyła http
        CarWash carWash = mapper.map(carWashDto, CarWash.class);
        carWashService.addCarWash(carWash);
        URI uri = uriBuilder.requestUriWithId(carWash.getId());
        return created(uri).build();
    }
}
