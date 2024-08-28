package com.app.service;

import java.util.List;

import org.springframework.security.oauth2.core.user.OAuth2User;

import com.app.dto.ApiResponse;
<<<<<<< HEAD

import com.app.dto.PasswordResetDto;

import com.app.dto.LoginDTO;

=======
import com.app.dto.PasswordResetDto;
import com.app.dto.LoginDTO;
>>>>>>> 412ad7e6bbe683ac256290346a0f4909d3e056c1
import com.app.dto.SignupDto;
import com.app.dto.UserDto;
import com.app.entity.User;


public interface UserService {
	ApiResponse userRegister(SignupDto signupDto);

	ApiResponse resetUserPassword(PasswordResetDto passwordResetDto);
	
	ApiResponse authenticateUser(LoginDTO loginDTO);

	User processOAuth2User(OAuth2User oAuth2User);

	
	
}
