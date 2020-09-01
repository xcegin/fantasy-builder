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
@Entity(name = "char_name")
@SequenceGenerator(name = "generator__seq_char_name__id", schema = "public", sequenceName = "seq_char_name_id",
        allocationSize = 1)
@ToString
public class CharName {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(readOnly = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator__seq_char_name__id")
    private Long id;

    @NotNull
    @Column(name = "char_name", nullable = false, unique = true,
            length = 50)
    private String charName;

    @Column(name = "description", unique = true,
            length = 500)
    private String description;

    @NotNull
    @Column(name = "is_alias", nullable = false)
    private Boolean isAlias;

    @NotNull
    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "char_id", nullable = false)
    private CharacterFantasy characterFantasy;
}
