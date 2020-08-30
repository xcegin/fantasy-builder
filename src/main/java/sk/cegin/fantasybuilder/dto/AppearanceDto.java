package sk.cegin.fantasybuilder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class AppearanceDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(readOnly = true)
    private Long id;
    private Integer age;
    private Integer ageOfAppearance;
    @NotNull
    private Boolean glasses;
    @NotNull
    private BigDecimal weight;
    @NotNull
    private BigDecimal height;
    private String eyeColor;
    private String skinColor;
    @NotNull
    private String typeOfBodyId;
    @NotNull
    private String shapeOfFaceId;
    @NotNull
    private String genderId;
    private String predominantFeature;
    private String posture;
    private String description;
}
