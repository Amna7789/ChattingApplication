package com.example.chattingapp.domain.inbound;

import com.example.chattingapp.domain.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDTOIn extends UserDTO {
    String id;
    String name;
    String email;
    String phoneNo;
    String password;


    public UserDTOIn(String id, String name, String email, String phoneNo, String password) {
        super(id, name, email, phoneNo);
        this.password = password;
    }
}
