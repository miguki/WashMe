package pl.com.sages.connect.profiles.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "Position")
@Data
public class PositionDto {

    @ApiModelProperty(required = true)
    private String name;
    private Date startDate;
    private Date endDate;
    private String company;
    private String location;
    private String description;

}
