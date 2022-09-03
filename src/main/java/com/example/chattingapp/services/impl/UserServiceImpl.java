package com.example.chattingapp.services.impl;

import com.example.chattingapp.datamodel.Repo.UserRepo;
import com.example.chattingapp.datamodel.User;
import com.example.chattingapp.domain.LoginDTO;
import com.example.chattingapp.domain.UserDTO;
import com.example.chattingapp.domain.inbound.LoginDTOIn;
import com.example.chattingapp.domain.inbound.UserDTOIn;
import com.example.chattingapp.services.IUserService;
import com.example.chattingapp.shared.GenericModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public List<UserDTO> allUsers() {
    /*    User user =  userRepo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);*/
        return userRepo.findAllUsers();
    }
   //ye abhi krna complete auth lgani yahan or post mapping mn lgani hai ye annoation jo bnayi thi validation ki
    @Override
    public boolean isValidUser(String email, String password) {

        User user = userRepo.findByEmailAndPassword(email,password);
        if(user != null)
           return true;
        return false;
    }

    @Override
    public void createNewUser(UserDTOIn userDTOIn) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTOIn, User.class);
        userRepo.save(user);
    }

   // @Override
    public LoginDTO login(LoginDTOIn loginDTOIn) {
        HttpServletRequest request1 =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String base64Auth = request1.getHeader("Authorization").substring(6);
        String credentials = new String(Base64.getDecoder().decode(base64Auth));
        String email = credentials.split(":")[0];
        String password = credentials.split(":")[1];
        User user = userRepo.findByEmailAndPassword(loginDTOIn.getEmail(), loginDTOIn.getPassword());
        ModelMapper modelMapper = new ModelMapper();
        LoginDTO loginDTO = modelMapper.map(loginDTOIn,LoginDTO.class);
        loginDTO.setLogin(false);
        //ye puchna mn ne
        if(user != null)
            loginDTO.setLogin(true);
//        User  user1 = modelMapper.map(loginDTO,User.class);
//
//        userRepo.save(user1);

        return loginDTO;

    }

    @Override
    public LoginDTO validateLogin() {
        HttpServletRequest request1 =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String base64Auth = request1.getHeader("Authorization").substring(6);
        String credentials = new String(Base64.getDecoder().decode(base64Auth));
        String email = credentials.split(":")[0];
        String password = credentials.split(":")[1];
        User user = userRepo.findByEmailAndPassword(email,password);
        ModelMapper modelMapper = new ModelMapper();
        LoginDTO loginDTO = modelMapper.map(user, LoginDTO.class);
        if(user == null)
            throw new  IllegalArgumentException("");
        loginDTO.setLogin(true);
        return loginDTO;
    }

    @Override
    public UserDTO createNewUsers(UserDTOIn userDTOIn) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = new UserDTO();
        User user = modelMapper.map(userDTOIn, User.class);
        userRepo.save(user);
        return userDTO;
    }
}
