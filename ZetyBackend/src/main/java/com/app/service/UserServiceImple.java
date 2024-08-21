package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.PasswordResetDto;
import com.app.dto.SignupDto;
import com.app.entity.User;

@Service
@Transactional
public class UserServiceImple implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public ApiResponse userRegister(SignupDto signupDto) {
		if (!signupDto.getPassword().equals(signupDto.getConfirmpassword())) {
			return new ApiResponse(false, "password dosen't match!");
		}

		if (userDao.existsByEmail(signupDto.getEmail())) {
			return new ApiResponse(false, "Email already exists");
		}

		User user = new User();
		user.setEmail(signupDto.getEmail());
		user.setPassword(passwordEncoder.encode(signupDto.getPassword()));
		userDao.save(user);
		return new ApiResponse(true, "User registered successfully");

	}

	@Override
	public ApiResponse resetUserPassword(PasswordResetDto passwordResetDto) {
		
		User user = userDao.findByEmail(passwordResetDto.getEmail()).
				orElseThrow(()->new RersourseNotFoundException("User cannot be found with this email"));
		
		if(!passwordResetDto.getNewPassword().equals(passwordResetDto.getConfirmNewPassword())) {
			
			return new ApiResponse(false,"Password dosent match!");
		}
		
		user.setPassword(passwordEncoder.encode(passwordResetDto.getNewPassword()));
		
		return new ApiResponse(true,"password reset sucsessfulyy");
	}
	
	
	

}
