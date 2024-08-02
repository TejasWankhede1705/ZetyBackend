package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.EducationDao;
import com.app.dto.BesicDetailsDto;
import com.app.dto.EducationDto;
import com.app.entity.BesicDetails;
import com.app.entity.Education;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

public class EducationServiceImlp {
	
	@Autowired
	private EducationDao educationDto;
	
	@Autowired
	private BesicDetailsDto besicDetailDao;
	
	@Autowired
	private ModelMapper mapper;
	

	public ApiResponse addEducation(EducationDto dto) {
//		educationDTO to Education
		Education entity=  mapper.map(dto, Education.class);
		
		BesicDetails bd=besicDetailDao.findById(dto.getEducationId()).orElseThrow();
		
		bd.addEducation(entity);
		educationDto.save(entity);
		return new ApiResponse("Education Details Added Successfully...");
		
		
}		

	public List<EducationDto> getEducation(Long educationId) {
		BesicDetails bd= besicDetailDao.findById(educationId).orElseThrow(()-> new RersourseNotFoundException("Education Not Found"));
		return bd.getEducation().stream()
				.map(exp->mapper.map(exp, EducationDto.class))
				.collect(Collectors.toList());	
		
	}

}
