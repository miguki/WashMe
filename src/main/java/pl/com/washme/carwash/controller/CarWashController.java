package pl.com.washme.carwash.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.com.washme.carwash.dto.CarWashDto;
import pl.com.washme.carwash.dto.CarWashPageDto;
import pl.com.washme.carwash.entity.CarWash;
import pl.com.washme.carwash.service.CarWashService;
import pl.com.washme.common.model.Mapper;
import pl.com.washme.common.model.ResultPage;
import pl.com.washme.common.web.UriBuilder;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity createCarWash(@ApiParam(name = "carWash") @RequestBody CarWashDto carWashDto) { //w odpowiedzi wysyła http
        CarWash carWash = mapper.map(carWashDto, CarWash.class);
        carWashService.addCarWash(carWash);
        URI uri = uriBuilder.requestUriWithId(carWash.getId());
        return created(uri).build();
    }
    @ApiOperation(value = "Get all car washes", response = CarWashPageDto.class)
    @RequestMapping(method = RequestMethod.GET)
    public CarWashPageDto getAllCarWashes(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "10", name = "pageSize") int pageSize) {
        ResultPage<CarWash> resultPage = carWashService.getAllCarWashes(pageNumber, pageSize);
        List<CarWashDto> carWashDtos = mapper.map(resultPage.getContent(), CarWashDto.class);
        return new CarWashPageDto(carWashDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
    }
}
