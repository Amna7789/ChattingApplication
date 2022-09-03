package com.example.chattingapp.datamodel.Repo;

import com.example.chattingapp.datamodel.User;
import com.example.chattingapp.domain.UserDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepo extends PagingAndSortingRepository<User, String> {
    @Query("select new com.example.chattingapp.domain.UserDTO(id, name, email,phoneNo) from User")
    List<UserDTO> findAllUsers();

    User findByEmailAndPassword(String email, String password);
}
