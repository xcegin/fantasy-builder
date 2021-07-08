package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.entity.ConfirmationToken;
import sk.cegin.fantasybuilder.entity.User;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;

public interface ConfirmationTokenService {

    ConfirmationToken createFromUser(User user);

    void saveConfirmationToken(ConfirmationToken confirmationToken);

    ConfirmationToken findByConfirmationToken(String confirmationToken) throws EntityNotFoundException;

    void deleteConfirmationToken(Long id);
}
