package sk.cegin.fantasybuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.cegin.fantasybuilder.entity.ConfirmationToken;
import sk.cegin.fantasybuilder.entity.User;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;
import sk.cegin.fantasybuilder.repository.ConfirmationTokenRepository;
import sk.cegin.fantasybuilder.service.api.ConfirmationTokenService;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public ConfirmationToken createFromUser(User user) {
        return new ConfirmationToken(user);
    }

    @Override
    @Transactional
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        confirmationTokenRepository.save(confirmationToken);
    }

    @Override
    @Transactional
    public ConfirmationToken findByConfirmationToken(String confirmationToken) throws EntityNotFoundException {
        return confirmationTokenRepository.findByConfirmationToken(confirmationToken)
                .orElseThrow(() -> new EntityNotFoundException(ConfirmationToken.class, confirmationToken));
    }

    @Override
    @Transactional
    public void deleteConfirmationToken(Long id) {
        confirmationTokenRepository.deleteById(id);
    }
}
