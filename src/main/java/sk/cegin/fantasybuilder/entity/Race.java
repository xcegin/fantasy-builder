package sk.cegin.fantasybuilder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Cacheable
@Entity(name = "race")
@SequenceGenerator(name = "generator__seq_race__id", schema = "public", sequenceName = "seq_race_id",
        allocationSize = 1)
@ToString
public class Race {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(readOnly = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator__seq_race__id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Column(name = "lifespan", nullable = false,
            length = 50)
    private String lifespan;

    @NotNull
    @Column(name = "height", nullable = false, length = 50)
    private String height;

    @NotNull
    @Column(name = "weight", nullable = false, length = 50)
    private String weight;

    @Column(name = "distinctions", nullable = false, length = 50)
    private String distinctions;

    @Column(name = "description", nullable = false)
    private String description;
}
