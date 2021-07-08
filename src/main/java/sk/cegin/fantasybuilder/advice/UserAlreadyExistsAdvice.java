package sk.cegin.fantasybuilder.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sk.cegin.fantasybuilder.exception.UserAlreadyExistsException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserAlreadyExistsAdvice {

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> userAlreadyExistsHandler(UserAlreadyExistsException ex) {
        Logger logger = LoggerFactory.getLogger(UserAlreadyExistsException.class);
        logger.error(ex.getMessage());
        Map<String,String> cause = new HashMap<>();
        cause.put("message", ex.getMessage());
        return cause;
    }
}
