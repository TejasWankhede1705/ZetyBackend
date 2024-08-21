package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.LoginDTO;
import com.app.dto.SignupDto;
import com.app.dto.UserDto;
import com.app.entity.User;


public interface UserService {
	ApiResponse userRegister(SignupDto signupDto);
	
	
//    String authenticateUser(LoginDTO loginDTO);

    ApiResponse authenticateUser(LoginDTO loginDTO);

	
	
}
