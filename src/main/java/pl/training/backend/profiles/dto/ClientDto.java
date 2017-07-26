package pl.training.backend.profiles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import pl.training.backend.security.dto.AuthorityDto;
import pl.training.backend.security.dto.UserDto;

import java.util.Set;

/**
 * Created by Jasiek on 26.07.2017.
 */
@ApiModel(value = "User")
@Data
public class ClientDto {

    @ApiModelProperty(required = true)
    @Autowired
    private UserDto userDto;
    @ApiModelProperty(required = true)
    private long id;
    @ApiModelProperty(required = true)
    private String name;
}
