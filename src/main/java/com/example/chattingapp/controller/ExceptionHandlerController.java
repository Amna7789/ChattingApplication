package com.example.chattingapp.controller;

import com.example.chattingapp.domain.ErrorDTO;
import com.example.chattingapp.domain.LoginDTO;
import com.example.chattingapp.shared.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> handleException(UserException userException){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTime(userException.getTime());
        errorDTO.setErrorMessage(userException.getMessage());
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


}
