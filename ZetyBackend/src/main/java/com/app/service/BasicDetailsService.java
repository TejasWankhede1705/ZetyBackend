package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.BesicDetailsDto;
import com.app.entity.BesicDetails;

public interface BasicDetailsService {

	BesicDetailsDto getBasicDetailsById(Long id); // Method to get basic details by ID

	ApiResponse addExperiance(BesicDetailsDto details);

}
