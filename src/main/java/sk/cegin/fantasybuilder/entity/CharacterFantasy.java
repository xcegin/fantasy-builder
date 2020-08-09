package sk.cegin.fantasybuilder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "characterfantasy")
@SequenceGenerator(name = "generator__seq_character__id", schema = "public", sequenceName = "seq_character_id",
        allocationSize = 1)
public class CharacterFantasy {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(readOnly = true)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "generator__seq_character__id")
    private Long id;

    @NotNull
    @Column(name = "char_name", insertable = true, updatable = true, nullable = false, unique = true,
            length = 50)
    private String charName;
}
