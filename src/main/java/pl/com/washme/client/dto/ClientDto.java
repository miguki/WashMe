package pl.com.washme.client.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Jasiek on 26.07.2017.
 */
@ApiModel(value = "Client")
@Data
public class ClientDto {

    @ApiModelProperty(required = true)
    private Long id;
    @ApiModelProperty(required = true)
    private String name;
    //URI Builder
}
