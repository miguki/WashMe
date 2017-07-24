package pl.com.sages.connect.profiles.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel(value = "Profiles")
@Data
public class ProfilesPageDto {

    private List<ProfileDto> profiles;
    private int pageNumber;
    private int totalPages;

    public ProfilesPageDto() {
    }

    public ProfilesPageDto(List<ProfileDto> profile, int pageNumber, int totalPages) {
        this.profiles = profiles;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }

}
