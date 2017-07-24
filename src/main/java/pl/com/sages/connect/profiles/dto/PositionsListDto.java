package pl.com.sages.connect.profiles.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel(value = "Positions")
@Data
public class PositionsListDto {

    private List<PositionDto> positions;

    public PositionsListDto() {
    }

    public PositionsListDto(List<PositionDto> positions) {
        this.positions = positions;
    }

}
