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
@Entity(name = "user_entity")
@SequenceGenerator(name = "generator__seq_user_entity__id", schema = "public", sequenceName = "seq_user_entity_id",
        allocationSize = 1)
@ToString
public class User {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(readOnly = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator__seq_user_entity__id")
    private Long id;

    @NotNull
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @NotNull
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @NotNull
    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @NotNull
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotNull
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = false;
}
