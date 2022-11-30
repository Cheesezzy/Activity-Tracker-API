package com.example.spring.demo.service;

import com.example.spring.demo.entity.User;
import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.UserLoginDto;
import com.example.spring.demo.pojos.UserRegisterDto;
import com.example.spring.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private final ResponseManager responseManager;
    private final UserRepo userRepo;

    public ApiResponse createUser(UserRegisterDto request){
        if (request.getUserName() == null)
            return responseManager.error("Name required!");
        else if (request.getEmail() == null)
            return responseManager.error("Email required!");
        else if (request.getPassword() == null)
            return responseManager.error("Password required!");

        boolean userExist = userRepo.existsByEmail(request.getEmail());
        if(userExist)
            return responseManager.error("User already exist!");

        User newUser= new User();
        newUser.setName(request.getUserName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword());
        newUser.setUuid(UUID.randomUUID().toString());
        newUser.setCreatedAt(new Date()); // change this to auto generated in the entity

        User savedUser = userRepo.save(newUser);
        return responseManager.success(savedUser);
    }
    public ApiResponse findById(Long id){
        User user = userRepo.findById(id).orElse(null);
        if (user != null)
            return responseManager.success(user);
        return responseManager.error("User not found");
    }

    public ApiResponse createUser(UserLoginDto request){
        User newUser= new User();
        if (request.getEmail() == null)
            return responseManager.error("Email required!");
        else if (request.getPassword() == null)
            return responseManager.error("Password required!");

        boolean userExist = userRepo.existsByEmail(request.getEmail());
        if(userExist)
            return responseManager.success("Welcome");
        return responseManager.success(request);
    }



}
