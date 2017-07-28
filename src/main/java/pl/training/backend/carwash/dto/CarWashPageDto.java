package pl.training.backend.carwash.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Jasiek on 27.07.2017.
 */

@ApiModel(value = "CarWashes")
@Data
public class CarWashPageDto {

    private List<CarWashDto> carWashes;
    private int pageNumber;
    private int totalPages;

    public CarWashPageDto() {
    }

    public CarWashPageDto(List<CarWashDto> carWashes, int pageNumber, int totalPages) {
        this.carWashes = carWashes;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }
}