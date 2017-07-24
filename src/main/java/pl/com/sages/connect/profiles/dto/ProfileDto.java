package pl.com.sages.connect.profiles.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pl.com.sages.connect.profiles.entity.Position;
import pl.com.sages.connect.profiles.entity.Skill;

import java.util.Set;

@ApiModel(value = "Profile")
@Data
public class ProfileDto {

    @ApiModelProperty(required = true)
    private String firstName;
    @ApiModelProperty(required = true)
    private String lastName;
    @ApiModelProperty(required = true)
    private String email;
    private String description;
    private Set<Position> positions;
    private Set<Skill> skills;

}
