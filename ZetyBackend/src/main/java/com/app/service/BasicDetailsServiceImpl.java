package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.BesicDetailsDao;
import com.app.dto.ApiResponse;
import com.app.dto.BesicDetailsDto;
import com.app.entity.BesicDetails;


@Service
@Transactional
public class BasicDetailsServiceImpl implements BasicDetailsService {

    @Autowired
    private BesicDetailsDao dao;
    
    @Autowired
    private ModelMapper mapper;

   

   
 

	@Override
	public ApiResponse addExperiance(BesicDetailsDto details) {
		BesicDetails b = mapper.map(details, BesicDetails.class);
		dao.save(b);
		return new ApiResponse("Besic details added sucsessfully");
	}



	@Override
	public BesicDetailsDto getBasicDetailsById(Long id) {
		// TODO Auto-generated method stub
		BesicDetails b = dao.findById(id).orElseThrow(()-> new RersourseNotFoundException("unable to find the user"));
		
		return mapper.map(b, BesicDetailsDto.class);
	}
}
