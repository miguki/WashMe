package pl.com.washme.job.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pl.com.washme.servicepackage.entity.ServicePackage;

import java.util.List;

@ApiModel(value = "Job")
@Data
public class JobDto {

    @ApiModelProperty
    private Long id;
    @ApiModelProperty(required = true)
    private Long userId;
    @ApiModelProperty(required = true)
    private Long servicePackageId;
    @ApiModelProperty(required = true)
    private List<Long> serviceTypesIds;
}
