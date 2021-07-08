package sk.cegin.fantasybuilder.service.api;

import sk.cegin.fantasybuilder.dto.UserDto;
import sk.cegin.fantasybuilder.entity.User;
import sk.cegin.fantasybuilder.exception.UserAlreadyExistsException;

public interface UserService {
    UserDto registerUser(UserDto userDto) throws UserAlreadyExistsException;
    void enableUser(User user);
}
