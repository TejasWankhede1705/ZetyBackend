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

import com.app.dto.BesicDetailsDto;

import com.app.service.BasicDetailsService;

@RestController
@RequestMapping("user")
public class BasicDetailsController {

    @Autowired
    private BasicDetailsService service;

    @PostMapping("/basicdetails")
    public ResponseEntity<?> addUsersBasicDetails(@RequestBody BesicDetailsDto details) {
      
    	return ResponseEntity.status(HttpStatus.CREATED).body(service.addExperiance(details));
    }
    
    @GetMapping("/{userId}/getBasicdetails")
    public ResponseEntity<?>getUserBasicDetails(@PathVariable Long userId){
    	
    	return ResponseEntity.ok(service.getBasicDetailsById(userId));
    }
    
    		

  
}
