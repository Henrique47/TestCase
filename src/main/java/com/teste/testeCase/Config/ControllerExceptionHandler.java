package com.teste.testeCase.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseBody
     public void handleMissingRequestHeaderException(MissingRequestHeaderException ex)
    {
        logger.error("handleMissingRequestHeaderException" + ex.getMessage());
    }
}