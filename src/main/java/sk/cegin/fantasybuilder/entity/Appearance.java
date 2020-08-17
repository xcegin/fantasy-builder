package sk.cegin.fantasybuilder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Cacheable
@Entity(name = "appearance")
@SequenceGenerator(name = "generator__seq_appearance__id", schema = "public", sequenceName = "seq_appearance_id",
        allocationSize = 1)
@ToString
public class Appearance {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(readOnly = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator__seq_appearance__id")
    private Long id;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "age_of_appearance", nullable = false)
    private Integer ageOfAppearance;

    @NotNull
    @Column(name = "glasses", nullable = false)
    private Boolean glasses = false;

    @NotNull
    @Column(name = "weight", nullable = false,
            precision = 2, scale = 10)
    private BigDecimal weight;

    @NotNull
    @Column(name = "height", nullable = false,
            precision = 2, scale = 10)
    private BigDecimal height;

    @Column(name = "eye_color", nullable = false, length = 10)
    private String eyeColor;

    @Column(name = "skin_color", nullable = false, length = 10)
    private String skinColor;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_body", nullable = false)
    @NotNull
    private TypeOfBody typeOfBody;

    @Enumerated(EnumType.STRING)
    @Column(name = "shape_of_face", nullable = false)
    @NotNull
    private ShapeOfFace shapeOfFace;

    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @Column(name = "predominant_feature", length = 100)
    private String predominantFeature;

    @NotNull
    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "char_id", nullable = false)
    private CharacterFantasy characterFantasy;

    @Column(name = "posture", length = 50)
    private String posture;

    @Column(name = "description")
    private String description;
}
