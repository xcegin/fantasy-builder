package sk.cegin.fantasybuilder.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GenderDto {
    @Id
    @ApiModelProperty(readOnly = true)
    @NotNull
    private String id;
    @NotNull
    private String title;
}
