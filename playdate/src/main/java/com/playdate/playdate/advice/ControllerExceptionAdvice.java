package com.playdate.playdate.advice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class ControllerExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleResourceNotFoundException(Exception e){
        log.warn("Invalid request received", e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void internalServerError(Exception e){
        log.warn("No response",e);
    }
}
