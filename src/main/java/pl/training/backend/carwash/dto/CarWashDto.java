package pl.training.backend.carwash.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Jasiek on 27.07.2017.
 */
@ApiModel(value = "CarWash")
@Data
public class CarWashDto {

    @ApiModelProperty(required = true)
    private Long id;
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private int slots;
}
