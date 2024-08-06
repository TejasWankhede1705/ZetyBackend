package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.BesicDetailsDao;
import com.app.dao.ExperianceDao;
import com.app.dto.ApiResponse;
import com.app.dto.ExperianceDto;
import com.app.entity.BesicDetails;
import com.app.entity.Experiance;

@Service
@Transactional
public class ExperianceServiceImpl implements ExperianceService {

	@Autowired
	private ExperianceDao experiancedao;
	
	@Autowired
	private BesicDetailsDao besicDetailsdao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ApiResponse addExperiance(ExperianceDto dto) {
	    // Map dto to entity
	    Experiance e = mapper.map(dto, Experiance.class);

	    // Find the BesicDetails entity using userId from dto
	    BesicDetails b = besicDetailsdao.findById(dto.getUserId()).orElseThrow(() -> new RersourseNotFoundException("User not found"));

	    // Set the relationship
	    e.setDetailsExperiance(b); // Associate the experience with the BesicDetails entity

	    // Save the experience entity
	    experiancedao.save(e);

	    return new ApiResponse("Experience Details added Successfully");
	}




	@Override
	public List<ExperianceDto> getExperiance(Long userId) {
	    BesicDetails b = besicDetailsdao.findById(userId)
	            .orElseThrow(() -> new RersourseNotFoundException("Experience Not Found"));

	    return b.getExperiance().stream()
	            .map(exp -> {
	                ExperianceDto dto = mapper.map(exp, ExperianceDto.class);
	                dto.setUserId(b.getId()); // Set userId from BesicDetails entity
	                return dto;
	            })
	            .collect(Collectors.toList());
	}


}
