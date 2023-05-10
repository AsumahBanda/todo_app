package com.example.to_do_app_backend.dto;

import com.example.to_do_app_backend.models.User;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.UUID;

public class UserDto {
  private final UUID id;
  private final String username;
  private final String email;
   private final String password;

    public UserDto(UUID id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User toUser(){
        return new User(id,username,email,password);
    }
}
