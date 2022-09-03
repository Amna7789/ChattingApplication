package com.example.chattingapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class ErrorDTO {
    String errorMessage;
    Date time;

    public ErrorDTO(String errorMessage, Date time) {
        this.errorMessage = errorMessage;
        this.time = time;
    }
}
