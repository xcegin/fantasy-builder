package sk.cegin.fantasybuilder.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CharacterFantasyDto {
    @ApiModelProperty(readOnly = true)
    private Long id;
    @NotNull
    private String codename;
}
