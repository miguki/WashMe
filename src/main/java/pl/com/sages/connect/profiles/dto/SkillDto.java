package pl.com.sages.connect.profiles.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Skill")
@Data
public class SkillDto {

    @ApiModelProperty(required = true)
    private String name;

}
