package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.BesicDetailsDto;

public interface BasicDetailsService {
    BesicDetailsDto getBasicDetailsById(Long id); // Method to get basic details by ID
    ApiResponse addBasicDetails(BesicDetailsDto details); // Renamed method
}
