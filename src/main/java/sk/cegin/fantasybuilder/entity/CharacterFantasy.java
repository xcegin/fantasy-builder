package sk.cegin.fantasybuilder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Cacheable
@Entity(name = "characterfantasy")
@SequenceGenerator(name = "generator__seq_characterfantasy__id", schema = "public", sequenceName = "seq_characterfantasy_id",
        allocationSize = 1)
@ToString
public class CharacterFantasy {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(readOnly = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator__seq_characterfantasy__id")
    private Long id;

    @NotNull
    @Column(name = "codename", nullable = false, unique = true,
            length = 50)
    private String codename;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "race_id", nullable = true)
    private Race race = null;
}
