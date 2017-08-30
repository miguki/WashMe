package pl.com.washme.servicepackage.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pl.com.washme.servicetype.entity.ServiceType;

import java.util.List;

@ApiModel(value = "ServicePackage")
@Data
public class ServicePackageViewDto {

    @ApiModelProperty
    private Long id;
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private Long price;
    @ApiModelProperty(required = true)
    private String description;
    @ApiModelProperty(required = true)
    private List<ServiceType> serviceTypes;
    //URI Builder
}
