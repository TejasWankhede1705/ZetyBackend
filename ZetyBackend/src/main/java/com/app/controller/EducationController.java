package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EducationDto;
import com.app.entity.Education;
<<<<<<< HEAD
import com.app.service.EducationSerivce;
import com.app.service.EducationServiceImlp;

@RestController
@RequestMapping("/user")
=======
import com.app.service.EducationServiceImlp;

@RestController
@RequestMapping("/education")
>>>>>>> fc14205f8127f4f9790d4e14b4de7f1074e58137
public class EducationController {
	
	
	@Autowired 
<<<<<<< HEAD
	private EducationSerivce educationService;
=======
	private EducationServiceImlp educationService;
>>>>>>> fc14205f8127f4f9790d4e14b4de7f1074e58137
	
	@PostMapping("/addeducation")
	public ResponseEntity<?> addEducation(@RequestBody EducationDto Dto)
	{
		System.out.println("No-Education Controller");
//		EducationDto addEducation = educationService.addEducation(education);
		return ResponseEntity.status(HttpStatus.CREATED).body(educationService.addEducation(Dto));
	}
	
	
<<<<<<< HEAD
	@GetMapping("/{userId}/geteducation")
	public ResponseEntity<?> viewAllEducation(@PathVariable Long userId) {
//		List<EducationDto> viewAll=educationService.viewAll();
		return ResponseEntity.ok(educationService.getEducation(userId));
=======
	@GetMapping("/vieweducation")
	public ResponseEntity<?> viewAllEducation(@PathVariable Long EducationId) {
//		List<EducationDto> viewAll=educationService.viewAll();
		return ResponseEntity.ok(educationService.getEducation(EducationId));
>>>>>>> fc14205f8127f4f9790d4e14b4de7f1074e58137
	}
}
