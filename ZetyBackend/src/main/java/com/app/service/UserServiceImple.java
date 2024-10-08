package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;

import com.app.dto.PasswordResetDto;

import com.app.dto.LoginDTO;

import com.app.dto.SignupDto;
import com.app.dto.UserDto;
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
	
	
	

    public String authenticateUser(LoginDTO loginDTO) {
        Optional<User> user = userDao.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());

        if (user.isPresent()) {
            return "User login successful";
        } else {
            throw new RuntimeException("Invalid email/username or password");
        }
    }

	@Override
	public User processOAuth2User(OAuth2User oAuth2User) {
	    String email = oAuth2User.getAttribute("email");
        String providerId = oAuth2User.getAttribute("id");

        if (email == null) {
            throw new OAuth2AuthenticationException("Email not found from OAuth2 provider");
        }

        Optional<User> userOptional = userDao.findByEmail(email);
        User user;

        if (userOptional.isPresent()) {
            user = userOptional.get();
            // Update existing user if necessary
        } else {
            user = new User();
            user.setEmail(email);
            user.setProvider("FACEBOOK");
            user.setProviderId(providerId);
            // Password can be null or a random UUID if required
            user.setPassword(null); // Since password is not needed for OAuth2 login

            user = userDao.save(user);

           
        }

        return user;
	}


}
