package com.example.to_do_app_backend.models;


import com.example.to_do_app_backend.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "app_users")
public class User {
  @Id
  //@GeneratedValue
  UUID id;

  @Column(name = "user_name")
  String username;

  @Column(name = "email")
  String email;

  @Column(name = "password")
  String password;

  public User() {

  }

  public User(UUID id, String username, String email, String password) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public UserDto toDto(){
    return  new UserDto(id,username,email,password);
  }
}
