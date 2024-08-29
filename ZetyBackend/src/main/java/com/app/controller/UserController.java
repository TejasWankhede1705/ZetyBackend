package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.LoginDTO;
import com.app.dto.PasswordResetDto;
import com.app.dto.SignupDto;
import com.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService service;

	@PostMapping("/signUp")
	public ResponseEntity<ApiResponse> registerUser(@RequestBody SignupDto signupDto) {
		ApiResponse response = service.userRegister(signupDto);
		if (response.isSuccess()) {
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO) {
		String response = service.authenticateUser(loginDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/resetPassword")
	public ResponseEntity<?> resetPassword(@RequestBody PasswordResetDto passwordResetDto) {

		return ResponseEntity.ok(service.resetUserPassword(passwordResetDto));
	}

}
