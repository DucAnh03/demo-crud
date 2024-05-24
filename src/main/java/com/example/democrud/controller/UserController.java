package com.example.democrud.controller;

import com.example.democrud.dto.request.ApiResponse;
import com.example.democrud.dto.request.UserRequest;

import com.example.democrud.dto.request.UserUpdateRequest;
import com.example.democrud.entity.User;
import com.example.democrud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private  UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserRequest req){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createRequest(req));
        return apiResponse;
    }
    @GetMapping
    List<User> getUser(){
        return userService.getUser();
    }
    @GetMapping("/{userId}")
    User getByID(@PathVariable("userId") String userId){
        return userService.getU(userId);

    }
    @PutMapping("/{userId}")
    User upadateUser(@PathVariable("userId") String userId,@RequestBody UserUpdateRequest req){
           return userService.update(userId, req);
    }
    @DeleteMapping("/{userId}")
    String delete(@PathVariable("userId") String userId){
                userService.delete(userId);
        return "User has been deleted";
    }
}
