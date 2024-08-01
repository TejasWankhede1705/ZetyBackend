package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ExperianceDto;
import com.app.service.ExperianceService;

@RestController
@RequestMapping("user")
public class ExperianceController {
	
	@Autowired
	private ExperianceService service ;
	
	
	
	@PostMapping("/experiance")
	public ResponseEntity<?> addExperianceDetails(@RequestBody ExperianceDto dto){
		
		System.out.println("inexperiance controller");
		return  ResponseEntity.status(HttpStatus.CREATED).body(service.addExperiance(dto));
	}
	
	@GetMapping("/{userId}/experiance")
	public ResponseEntity<?> getExperianceDetails(@PathVariable Long userId){
		
		return ResponseEntity.ok(service.getExperiance()); 
	}

}