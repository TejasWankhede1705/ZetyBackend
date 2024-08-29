package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CertificationDto;
import com.app.service.CertifiactionService;

@CrossOrigin
@RestController
@RequestMapping("/uer")
public class CertificationController {
	
	@Autowired
	private CertifiactionService service;
	
	@PostMapping("/addCertification")
	ResponseEntity<?>addCertificationDetails(@RequestBody CertificationDto dto){
		return ResponseEntity.ok(service.addCertification(dto));
	}
	//to retrive spaerate certification
	@GetMapping("/getCertification/{id}")
	ResponseEntity<?>getCertificationDetails(@PathVariable Long id){
		return ResponseEntity.ok(service.getCertification(id));
	}
	
	//to retrive all the certification related to user Education
	@GetMapping("/getAllCertification/{educationId}")
	ResponseEntity<?>getAllCertificationsforEducation(@PathVariable Long educationId){
		return ResponseEntity.ok(service.getAllCertificationDetails(educationId));
		
	}
	
	@PutMapping("/updateCertification/{id}")
	ResponseEntity<?>updateCertificationDetails(@PathVariable Long id,@RequestBody CertificationDto dto){
		return ResponseEntity.ok(service.updateCertification(id,dto));
	}
	
	@DeleteMapping("/deleteCertification/{certifiactionId}")
	ResponseEntity<?>deleteCertificationDetails(@PathVariable Long certificationId){
		return ResponseEntity.ok(service.deleteCertification(certificationId));
	}
}
