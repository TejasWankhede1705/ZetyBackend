package com.app.service;

<<<<<<< HEAD
import com.app.dto.ApiResponse;
import java.util.List;
import java.util.stream.Collectors;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.BesicDetailsDao;
import com.app.dao.EducationDao;

=======
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.EducationDao;
import com.app.dto.BesicDetailsDto;
>>>>>>> fc14205f8127f4f9790d4e14b4de7f1074e58137
import com.app.dto.EducationDto;
import com.app.entity.BesicDetails;
import com.app.entity.Education;

<<<<<<< HEAD

@Service
public class EducationServiceImlp implements EducationSerivce{
	
	@Autowired
	private EducationDao educationdao;
	
	@Autowired
	private BesicDetailsDao besicDetailDao;
=======
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public class EducationServiceImlp {
	
	@Autowired
	private EducationDao educationDto;
	
	@Autowired
	private BesicDetailsDto besicDetailDao;
>>>>>>> fc14205f8127f4f9790d4e14b4de7f1074e58137
	
	@Autowired
	private ModelMapper mapper;
	

	public ApiResponse addEducation(EducationDto dto) {
//		educationDTO to Education
<<<<<<< HEAD
		Education e =  mapper.map(dto, Education.class);
		
		BesicDetails bd = besicDetailDao.findById(dto.getId()).orElseThrow();
		
		bd.addEducation(e);
		educationdao.save(e);
		return new ApiResponse("Education details added Sucsessfully");
=======
		Education entity=  mapper.map(dto, Education.class);
		
		BesicDetails bd=besicDetailDao.findById(dto.getEducationId()).orElseThrow();
		
		bd.addEducation(entity);
		educationDto.save(entity);
		return new ApiResponse("Education Details Added Successfully...");
>>>>>>> fc14205f8127f4f9790d4e14b4de7f1074e58137
		
		
}		

<<<<<<< HEAD
	public List<EducationDto> getEducation(Long userId) {
		BesicDetails bd= besicDetailDao.findById(userId).orElseThrow(()-> new RersourseNotFoundException("Education Not Found"));
=======
	public List<EducationDto> getEducation(Long educationId) {
		BesicDetails bd= besicDetailDao.findById(educationId).orElseThrow(()-> new RersourseNotFoundException("Education Not Found"));
>>>>>>> fc14205f8127f4f9790d4e14b4de7f1074e58137
		return bd.getEducation().stream()
				.map(exp->mapper.map(exp, EducationDto.class))
				.collect(Collectors.toList());	
		
	}

}
