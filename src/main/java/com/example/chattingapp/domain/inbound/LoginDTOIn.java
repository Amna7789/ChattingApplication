package com.example.chattingapp.domain.inbound;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class LoginDTOIn {
@NotNull
@NotEmpty
@Email

    String email;
@NotNull
@NotEmpty
@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{5,20}$")
    String password;


    public LoginDTOIn(String email, String password) {
        this.email = email;
        this.password = password;

    }
}
