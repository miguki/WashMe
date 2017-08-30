package pl.com.washme.servicepackage.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel(value = "ServicePackages")
@Data
public class ServicePackagePageDto {

    private List<ServicePackageViewDto> servicePackages;
    private int pageNumber;
    private int totalPages;

    public ServicePackagePageDto() {
    }

    public ServicePackagePageDto(List<ServicePackageViewDto> servicePackages, int pageNumber, int totalPages) {
        this.servicePackages = servicePackages;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }
}

