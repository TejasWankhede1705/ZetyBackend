package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.BesicDetailsDto;
import com.app.entity.BesicDetails;

public interface BasicDetailsService {
    BesicDetailsDto getBasicDetailsById(Long id); 
    ApiResponse addBasicDetails(BesicDetailsDto details); 
    ApiResponse updateBasicDetails(Long id,BesicDetailsDto details);
}
