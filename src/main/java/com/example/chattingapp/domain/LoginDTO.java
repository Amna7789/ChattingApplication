package com.example.chattingapp.domain;

import com.example.chattingapp.domain.inbound.LoginDTOIn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginDTO extends LoginDTOIn {
    boolean login;

    public LoginDTO(String email, String password, boolean login) {
        super(email, password);
        this.login = login;
    }
}
