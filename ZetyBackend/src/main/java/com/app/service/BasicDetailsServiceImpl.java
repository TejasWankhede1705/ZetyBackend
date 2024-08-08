package com.app.service;

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
}
