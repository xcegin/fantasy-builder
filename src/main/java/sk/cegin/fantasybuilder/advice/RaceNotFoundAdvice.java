package sk.cegin.fantasybuilder.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sk.cegin.fantasybuilder.exception.RaceNotFoundException;

@ControllerAdvice
public class RaceNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(RaceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String raceNotFoundHandler(RaceNotFoundException ex) {
        Logger logger = LoggerFactory.getLogger(RaceNotFoundException.class);
        logger.error(ex.getMessage());
        return ex.getMessage();
    }
}
