package com.example.chattingapp.controller;

import com.example.chattingapp.controller.annotation.Validation;
import com.example.chattingapp.domain.LoginDTO;
import com.example.chattingapp.domain.UserDTO;
import com.example.chattingapp.domain.inbound.LoginDTOIn;
import com.example.chattingapp.domain.inbound.UserDTOIn;
import com.example.chattingapp.services.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    IUserService userService;
    @ResponseStatus(HttpStatus.OK)

    @GetMapping("/user/allUsers")
    public List<UserDTO> getAllUsers(){

        return userService.allUsers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    //signup hai
    @PostMapping("/user/createUser")
    public void createUser(@RequestBody UserDTOIn userDTOIn){
        userService.createNewUser(userDTOIn);
    }
    //for testing custom Exception
    @Validation(value = "")
    @PostMapping("/user/createUsers")
    public UserDTO createUsers(@RequestBody UserDTOIn userDTOIn){
        return userService.createNewUsers(userDTOIn);
    }
   // @Validation(value = "")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/login")
    public LoginDTO checklogin(@Valid @RequestBody LoginDTOIn loginDTOIn){
        return userService.login(loginDTOIn);

    }
    @GetMapping("user/login/request")
    public LoginDTO testlogin(){
        return userService.validateLogin();
    }

}
