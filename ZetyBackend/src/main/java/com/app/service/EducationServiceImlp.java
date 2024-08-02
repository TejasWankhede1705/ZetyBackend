package com.app.service;

import com.app.dto.ApiResponse;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.BesicDetailsDao;
import com.app.dao.EducationDao;

import com.app.dto.EducationDto;
import com.app.entity.BesicDetails;
import com.app.entity.Education;

@Service
public class EducationServiceImlp implements EducationSerivce {

	@Autowired
	private EducationDao educationdao;

	@Autowired
	private BesicDetailsDao besicDetailDao;

	@Autowired
	private ModelMapper mapper;

	public ApiResponse addEducation(EducationDto dto) {
//		educationDTO to Education

		Education e = mapper.map(dto, Education.class);

		BesicDetails bd = besicDetailDao.findById(dto.getId()).orElseThrow();

		bd.addEducation(e);
		educationdao.save(e);
		return new ApiResponse("Education details added Sucsessfully");

	}

	public List<EducationDto> getEducation(Long userId) {
		BesicDetails bd = besicDetailDao.findById(userId)
				.orElseThrow(() -> new RersourseNotFoundException("Education Not Found"));

		return bd.getEducation().stream().map(exp -> mapper.map(exp, EducationDto.class)).collect(Collectors.toList());

	}

}
