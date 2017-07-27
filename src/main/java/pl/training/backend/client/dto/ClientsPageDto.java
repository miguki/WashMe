package pl.training.backend.client.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel(value = "Clients")
@Data
public class ClientsPageDto {

    private List<ClientDto> clients;
    private int pageNumber;
    private int totalPages;

    public ClientsPageDto() {
    }

    public ClientsPageDto(List<ClientDto> clients, int pageNumber, int totalPages) {
        this.clients = clients;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }

}
