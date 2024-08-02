package com.app.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.BesicDetailsDao;
import com.app.dao.SkillDao;
import com.app.dto.ApiResponse;
import com.app.dto.SkillDto;
import com.app.entity.BesicDetails;
import com.app.entity.Skill;
import com.app.entity.SkillType;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	private SkillDao dao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	BesicDetailsDao basicDetailsDao;

	@Override
	public ApiResponse addSkills(SkillDto dto) {
	    Skill skills = new Skill(dto.getSkills(), dto.getSkillType()); 
	    BesicDetails details = basicDetailsDao.findById(dto.getUserId())
	        .orElseThrow(() -> new RersourseNotFoundException("User not found"));

	    details.addSkill(skills);
	    dao.save(skills); 
	    return new ApiResponse("Skills added successfully");
	}


	@Override
	public List<SkillDto> getSkills(Long userId) {
	    BesicDetails b = basicDetailsDao.findById(userId)
	        .orElseThrow(() -> new RersourseNotFoundException("User Not Found"));
	    
	    List<Skill> skills = b.getSkills(); 
	    System.out.println("Fetched Skills: " + skills);

	    return skills.stream()
	        .map(skill -> {
	            SkillDto dto = mapper.map(skill, SkillDto.class);
	            dto.setSkills(skill.getSkills());
	            dto.setSkillType(skill.getSkillType());
	            dto.setUserId(userId);
	            return dto;
	        })
	        .collect(Collectors.toList());
	}

}
