package sk.cegin.fantasybuilder.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class IllegalArgumentAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> illegalArgument(IllegalArgumentException ex) {
        Logger logger = LoggerFactory.getLogger(IllegalArgumentException.class);
        String message = ex.getMessage();
        String PACKAGE_PATH = "fantasybuilder.";
        if (message.contains(PACKAGE_PATH) && message.contains("enum")){
            message = message.substring(0, message.indexOf("sk.")) + message.substring(message.indexOf(PACKAGE_PATH) + PACKAGE_PATH.length());
        }
        Map<String,String> cause = new HashMap<>();
        cause.put("message", message);
        logger.error(ex.getMessage());
        return cause;
    }
}
