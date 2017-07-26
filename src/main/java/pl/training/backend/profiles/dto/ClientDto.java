package pl.training.backend.profiles.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pl.training.backend.security.dto.UserDto;

/**
 * Created by Jasiek on 26.07.2017.
 */
@ApiModel(value = "Client")
@Data
public class ClientDto {

    @ApiModelProperty(required = true)
    private UserDto userDto;
    @ApiModelProperty(required = true)
    private long id;
    @ApiModelProperty(required = true)
    private String name;
    //URI Builder
}
