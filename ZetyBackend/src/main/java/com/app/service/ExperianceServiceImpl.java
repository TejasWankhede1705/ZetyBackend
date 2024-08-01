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
		
		Experiance e = mapper.map(dto, Experiance.class);
		
		BesicDetails b = besicDetailsdao.findById(dto.getUserId()).orElseThrow();
		
		b.addExperance(e);
		
		experiancedao.save(e);
		return new ApiResponse("Experiance Details added Sucssessfully");
	}



	@Override
	public List<ExperianceDto> getExperiance(Long userId) {
		BesicDetails b = besicDetailsdao.findById(userId).orElseThrow(()-> new RersourseNotFoundException("User Not Found"));
		return b.getExperiance().stream()
				.map(exp->mapper.map(exp, ExperianceDto.class))
				.collect(Collectors.toList());
	}

}
