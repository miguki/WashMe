package pl.com.sages.connect.profiles.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel(value = "Skills")
@Data
public class SkillsListDto {

    private List<SkillDto> skills;

    public SkillsListDto() {
    }

    public SkillsListDto(List<SkillDto> skills) {
        this.skills = skills;
    }

}
