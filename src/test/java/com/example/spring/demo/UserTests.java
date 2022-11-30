package com.example.spring.demo;

import com.example.spring.demo.entity.User;
import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.UserRegisterDto;
import com.example.spring.demo.repository.UserRepo;
import com.example.spring.demo.service.ResponseManager;
import com.example.spring.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserTests {
	@Mock
	ResponseManager responseManager;
	@Mock
	UserRepo userRepo;
	@InjectMocks
	UserService userService;

	@Test
	void createUserTest() {
		UserRegisterDto userdto = new UserRegisterDto();
		userdto.setUserName("janet");
		userdto.setEmail("janet@gmail.com");
		userdto.setPassword("123456");

		User newUser= new User();
        newUser.setName(userdto.getUserName());
        newUser.setEmail(userdto.getEmail());
        newUser.setPassword(userdto.getPassword());

		User savedUser = userRepo.save(newUser);

		ApiResponse res = userService.createUser(userdto);
		ApiResponse req = responseManager.success(savedUser);

		Assertions.assertEquals(res,req);
	}


}
