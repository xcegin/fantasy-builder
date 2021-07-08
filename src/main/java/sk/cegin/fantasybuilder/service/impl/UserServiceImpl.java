package sk.cegin.fantasybuilder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.cegin.fantasybuilder.dto.UserDto;
import sk.cegin.fantasybuilder.entity.ConfirmationToken;
import sk.cegin.fantasybuilder.entity.User;
import sk.cegin.fantasybuilder.exception.UserAlreadyExistsException;
import sk.cegin.fantasybuilder.repository.UserRepository;
import sk.cegin.fantasybuilder.service.api.ConfirmationTokenService;
import sk.cegin.fantasybuilder.service.api.EmailService;
import sk.cegin.fantasybuilder.service.api.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private EmailService emailService;

    @Override
    @Transactional
    public UserDto registerUser(UserDto userDto) throws UserAlreadyExistsException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistsException(User.class, userDto.getEmail());
        }
        User newUser = convertToEntity(userDto);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser = userRepository.save(newUser);
        ConfirmationToken confirmationToken = confirmationTokenService.createFromUser(newUser);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        emailService.sendConfirmationMail(newUser.getEmail(), confirmationToken.getConfirmationToken());
        return convertToDto(newUser);
    }

    @Override
    @Transactional
    public void enableUser(User user) {
        user.setEnabled(true);
        userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User convertToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }
}
