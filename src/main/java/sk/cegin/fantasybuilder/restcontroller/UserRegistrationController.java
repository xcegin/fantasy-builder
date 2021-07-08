package sk.cegin.fantasybuilder.restcontroller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.cegin.fantasybuilder.dto.UserDto;
import sk.cegin.fantasybuilder.entity.ConfirmationToken;
import sk.cegin.fantasybuilder.entity.User;
import sk.cegin.fantasybuilder.exception.EntityNotFoundException;
import sk.cegin.fantasybuilder.exception.UserAlreadyExistsException;
import sk.cegin.fantasybuilder.service.api.ConfirmationTokenService;
import sk.cegin.fantasybuilder.service.api.UserService;

import javax.validation.Valid;

import static sk.cegin.fantasybuilder.config.RestConstants.*;

@RestController
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @PostMapping(path = REGISTRATION_MAPPING_PATH, produces = JSON_CONTENT_TYPE, consumes = JSON_CONTENT_TYPE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 409, message = "User already exists with email: {email}")
    })
    public UserDto register(@Valid @RequestBody UserDto resource) throws UserAlreadyExistsException {
        return userService.registerUser(resource);
    }

    @PostMapping(path = LOGIN_MAPPING_PATH, produces = JSON_CONTENT_TYPE, consumes = JSON_CONTENT_TYPE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 409, message = "User already exists with email: {email}")
    })
    public UserDto login(@Valid @RequestBody UserDto resource) throws UserAlreadyExistsException {
        return userService.registerUser(resource);
    }

    @GetMapping(path = CONFIRM_USER_MAPPING_PATH, produces = TEXT_PLAIN_CONTENT_TYPE)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Confirmation token not found with token: {token}"),
            @ApiResponse(code = 403, message = "Token already used.")
    })
    public ResponseEntity<?>  confirmMail(@RequestParam(TOKEN_PLACEHOLDER) String token) throws EntityNotFoundException {

        ConfirmationToken confirmationToken = confirmationTokenService.findByConfirmationToken(token);
        User user = confirmationToken.getUser();
        if (user.getEnabled()) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Token already used.");
        }
        userService.enableUser(confirmationToken.getUser());
        //TODO: code the sign in
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }
}
