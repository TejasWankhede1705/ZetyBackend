package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
<<<<<<< HEAD
import com.app.dto.PasswordResetDto;
=======
import com.app.dto.LoginDTO;
>>>>>>> 0cd651a648dea8a5002e17c3e2816e2611ccba2e
import com.app.dto.SignupDto;
import com.app.dto.UserDto;
import com.app.entity.User;


public interface UserService {
	ApiResponse userRegister(SignupDto signupDto);

	ApiResponse resetUserPassword(PasswordResetDto passwordResetDto);
	
	
//    String authenticateUser(LoginDTO loginDTO);

    String authenticateUser(LoginDTO loginDTO);

	
	
}
