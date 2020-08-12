package sk.cegin.fantasybuilder.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CharNameDto {

    @ApiModelProperty(readOnly = true)
    private Long id;

    @NotNull
    private String charName;

    private String description;

    @NotNull
    private Boolean isAlias;
}
