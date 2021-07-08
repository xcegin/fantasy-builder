package sk.cegin.fantasybuilder.repository;

import org.springframework.data.repository.CrudRepository;
import sk.cegin.fantasybuilder.entity.ConfirmationToken;

import java.util.Optional;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findById(long id);
    Optional<ConfirmationToken> findByConfirmationToken(String token);
}
