package pl.com.washme.servicetype.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ServiceType")
@Data
public class ServiceTypeDto {

    @ApiModelProperty
    private Long id;
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private Long price;
    @ApiModelProperty(required = true)
    private Long duration;
}
