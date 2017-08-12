package pl.com.washme.reservation.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pl.com.washme.carwash.dto.CarWashDto;
import pl.com.washme.client.dto.ClientDto;

import java.util.Date;

/**
 * Created by Jasiek on 27.07.2017.
 */
@ApiModel(value = "Reservation")
@Data
public class ReservationDto {

    @ApiModelProperty(required = true)
    private Long id;
    @ApiModelProperty(required = true)
    private Date startHour;
    @ApiModelProperty(required = true)
    private Date endHour;
    @ApiModelProperty(required = true)
    private ClientDto client;
    @ApiModelProperty(required = true)
    private CarWashDto carWash;
}
