package sk.cegin.fantasybuilder.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity(name = "confirmation_token")
@SequenceGenerator(name = "generator__seq_confirmation_token__id", schema = "public", sequenceName = "seq_confirmation_token_id",
        allocationSize = 1)
@ToString
@Cacheable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationToken {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(readOnly = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator__seq_confirmation_token__id")
    private Long id;

    @NotNull
    @Column(name = "confirmation_token", nullable = false, unique = true,
            length = 200)
    private String confirmationToken;

    @NotNull
    @Column(name = "created_date")
    private Date createdDate;

    @NotNull
    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public ConfirmationToken(User user) {
        this.user = user;
        this.createdDate =  new Date();
        this.confirmationToken = UUID.randomUUID().toString();
    }
}
