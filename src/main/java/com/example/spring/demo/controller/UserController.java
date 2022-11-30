package com.example.spring.demo.controller;

import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.UserLoginDto;
import com.example.spring.demo.pojos.UserRegisterDto;
import com.example.spring.demo.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ApiResponse createUser(@RequestBody UserLoginDto request){
        return userService.createUser(request);
    }

    @GetMapping("/{id}")
    public ApiResponse findUserById(@PathVariable Long id){
        return userService.findById(id);
    }
    @PostMapping("/register")
    public ApiResponse registerUser(@RequestBody UserRegisterDto userRegisterDto){
        return userService.createUser(userRegisterDto);
    }

}
