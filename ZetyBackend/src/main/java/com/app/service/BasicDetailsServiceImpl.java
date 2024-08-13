package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.BesicDetailsDao;
import com.app.dto.ApiResponse;
import com.app.dto.BesicDetailsDto;
import com.app.dto.CombinedResponseDto;
import com.app.dto.EducationDto;
import com.app.dto.ExperianceDto;
import com.app.dto.ResponseEducationDto;
import com.app.dto.ResponseExperianceDto;
import com.app.dto.ResponseProjectDto;
import com.app.dto.ResponseSkillsDto;
import com.app.dto.SkillDto;
import com.app.entity.BesicDetails;

@Service
@Transactional
public class BasicDetailsServiceImpl implements BasicDetailsService {

    @Autowired
    private BesicDetailsDao dao;
    
    @Autowired
    private ModelMapper mapper;

    @Override
    public ApiResponse addBasicDetails(BesicDetailsDto details) { // Renamed method
        BesicDetails b = mapper.map(details, BesicDetails.class);
        dao.save(b);
        return new ApiResponse("Basic details added successfully");
    }

    @Override
    public BesicDetailsDto getBasicDetailsById(Long id) {
        BesicDetails b = dao.findById(id)
                .orElseThrow(() -> new RersourseNotFoundException("Unable to find the user"));
        return mapper.map(b, BesicDetailsDto.class);
    }

	@Override
	public ApiResponse updateBasicDetails(Long id, BesicDetailsDto details) {
        BesicDetails existingDetails = dao.findById(id)
        		.orElseThrow(()-> new RersourseNotFoundException("unable to find the user"));
        mapper.map(details, existingDetails);
        dao.save(existingDetails);
		return new ApiResponse("Basic details updated succesfully");
	}

	@Override
	public ApiResponse deleteBesicdetails(Long userId) {
		BesicDetails b = dao.findById(userId).orElseThrow(()->new RersourseNotFoundException("user cannot be found"));
		
		dao.delete(b);
		return new ApiResponse("besic details have been deleted");
	}

	//To get The Combined Data
	@Override
	public CombinedResponseDto getCombinedData(Long id) {
		
		BesicDetails besicDetails = dao.findById(id).orElseThrow(()->new RersourseNotFoundException("Details Cannot be found"));
		
		CombinedResponseDto responseDto = new CombinedResponseDto();
		
		
		
		List<ResponseEducationDto>education = besicDetails.getEducation().stream().map(e->mapper.map(e, ResponseEducationDto.class)).
										collect(Collectors.toList());
		
		
		List<ResponseExperianceDto>experiance = besicDetails.getExperiance().stream().map(e->mapper.map(e, ResponseExperianceDto.class)).
										collect(Collectors.toList());
		
		List<ResponseSkillsDto>skills = besicDetails.getSkills().stream().map(s->mapper.map(s, ResponseSkillsDto.class)).
										collect(Collectors.toList());
		
		List<ResponseProjectDto>project = besicDetails.getProjects().stream().map(p->mapper.map(p, ResponseProjectDto.class)).
										collect(Collectors.toList());
		
		BesicDetailsDto besicDetailsDto = mapper.map(besicDetails, BesicDetailsDto.class);
		
		
		responseDto.setBesicDetails(besicDetailsDto);
		responseDto.setEducationList(education);
		responseDto.setExperianceList(experiance);
		responseDto.setProjectList(project);
		responseDto.setSkillList(skills);
		
		
		System.out.println(responseDto);
		
		return responseDto;
	}
	
	
}
