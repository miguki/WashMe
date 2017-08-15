package pl.com.washme.servicetype.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.util.List;

@ApiModel(value = "ServiceTypes")
@Data
public class ServiceTypePageDto {

    private List<ServiceTypeDto> ServiceTypes;
    private int pageNumber;
    private int totalPages;

    public ServiceTypePageDto() {
    }

    public ServiceTypePageDto(List<ServiceTypeDto> ServiceTypes, int pageNumber, int totalPages) {
        this.ServiceTypes = ServiceTypes;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }
}

