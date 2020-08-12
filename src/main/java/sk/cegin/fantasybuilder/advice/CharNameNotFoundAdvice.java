package sk.cegin.fantasybuilder.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sk.cegin.fantasybuilder.exception.CharNameNotFoundException;

@ControllerAdvice
public class CharNameNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CharNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String charNameNotFoundHandler(CharNameNotFoundException ex) {
        Logger logger = LoggerFactory.getLogger(CharNameNotFoundException.class);
        logger.error(ex.getMessage());
        return ex.getMessage();
    }
}
