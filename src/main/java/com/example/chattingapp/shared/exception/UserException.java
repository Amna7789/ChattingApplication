package com.example.chattingapp.shared.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class UserException extends RuntimeException{
    Date time;
    public UserException(String message){
        super(message);
        time = new Date(System.currentTimeMillis());
    }

}
