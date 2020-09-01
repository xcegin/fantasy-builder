package sk.cegin.fantasybuilder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Cacheable
@Entity(name = "gender")
@ToString
public class Gender {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(readOnly = true)
    @Column(name = "id", updatable = false, unique = true, nullable = false, length = 10)
    private String id;

    @Column(name = "title", updatable = false, unique = true, nullable = false, length = 50)
    @NotNull
    private String title;
}
