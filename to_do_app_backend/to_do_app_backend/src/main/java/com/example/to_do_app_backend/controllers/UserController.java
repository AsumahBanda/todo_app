package com.example.to_do_app_backend.controllers;
import com.example.to_do_app_backend.MyConstants;
import com.example.to_do_app_backend.dto.PaginationResponse;
import com.example.to_do_app_backend.dto.TaskDto;
import com.example.to_do_app_backend.dto.UserDto;
import com.example.to_do_app_backend.models.User;
import com.example.to_do_app_backend.services.TaskService;
import com.example.to_do_app_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(MyConstants.userEndPoint)
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @GetMapping
   ResponseEntity<PaginationResponse<UserDto>> getAll(@RequestParam(defaultValue = "0",required = false) int page,
                                                      @RequestParam(defaultValue = "10",required = false) int size){
        PaginationResponse<UserDto> results= userService.getAll(page,size);
       if(results ==null){
           return  ResponseEntity.noContent().build();
       }
       return ResponseEntity.ok(results);
    }

    @PostMapping("register")
    ResponseEntity<UserDto> registerUser( @RequestBody User reqUser){
        UserDto user = userService.registerUser(reqUser);
        if(user ==null) {
          return   ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/tasks")
    public ResponseEntity<Optional<List<TaskDto>>> getPeopleByParam( @RequestParam(required = false) Long userId) {
        Optional<List<TaskDto>> tasks = taskService.getTaskByUserId(userId);
        if(tasks.isPresent()){
            return  ResponseEntity.ok(tasks);
        };
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/login")
    ResponseEntity<UserDto> logIn(@RequestParam("username") String username, @RequestParam("password") String password){
      UserDto user =   userService.logIn(username,password);
      if(user ==null){
          return ResponseEntity.noContent().build();
      }
      return  ResponseEntity.ok(user);
    }
}
