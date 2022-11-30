package com.example.spring.demo.pojos;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
}
