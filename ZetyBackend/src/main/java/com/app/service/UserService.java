package com.app.service;

import java.util.List;

import org.springframework.security.oauth2.core.user.OAuth2User;

import com.app.dto.ApiResponse;

import com.app.dto.PasswordResetDto;

import com.app.dto.LoginDTO;

import com.app.dto.SignupDto;
import com.app.dto.UserDto;
import com.app.entity.User;


public interface UserService {
	ApiResponse userRegister(SignupDto signupDto);

	ApiResponse resetUserPassword(PasswordResetDto passwordResetDto);
	
	
//    String authenticateUser(LoginDTO loginDTO);

    String authenticateUser(LoginDTO loginDTO);

	User processOAuth2User(OAuth2User oAuth2User);

	
	
}
