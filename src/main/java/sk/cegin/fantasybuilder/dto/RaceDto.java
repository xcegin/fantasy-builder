package sk.cegin.fantasybuilder.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RaceDto {
    @ApiModelProperty(readOnly = true)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lifespan;

    @NotNull
    private String height;

    @NotNull
    private String weight;

    private String distinctions;

    private String description;
}
