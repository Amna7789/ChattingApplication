package com.example.chattingapp.services;

import com.example.chattingapp.domain.LoginDTO;
import com.example.chattingapp.domain.UserDTO;
import com.example.chattingapp.domain.inbound.LoginDTOIn;
import com.example.chattingapp.domain.inbound.UserDTOIn;

import java.util.List;

public interface IUserService {
   public List<UserDTO> allUsers();

   public boolean isValidUser(String email, String password);

  public void createNewUser(UserDTOIn userDTOIn);

   public LoginDTO login(LoginDTOIn loginDTOIn);

   public LoginDTO validateLogin();

   public UserDTO createNewUsers(UserDTOIn userDTOIn);
}
