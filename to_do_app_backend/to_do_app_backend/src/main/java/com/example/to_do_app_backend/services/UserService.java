package com.example.to_do_app_backend.services;
import com.example.to_do_app_backend.dto.PaginationResponse;
import com.example.to_do_app_backend.dto.UserDto;
import com.example.to_do_app_backend.models.User;
import com.example.to_do_app_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

   public PaginationResponse<UserDto> getAll(int page, int size){
        Page<User> data =
                userRepository.findAll(PageRequest.of(page,size, Sort.by(Sort.Direction.ASC,"username")));
        List<UserDto> users = data.map(User::toDto).stream().toList();
        return new PaginationResponse<UserDto>(
                users,
                data.getSize(),
                data.getNumber(),
                data.getTotalPages(),
                data.getTotalElements());

    }

    public UserDto registerUser(User user){
        UUID uuid =  UUID.randomUUID();
       user.setId(uuid);
      return   userRepository.save(user).toDto();
    }

    public UserDto logIn(String username, String password){
     return userRepository.findByUsernameAndPassword(username,password).toDto();
    }
}
