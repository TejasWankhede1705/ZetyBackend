package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ExperianceDto;

public interface ExperianceService {

	ApiResponse addExperiance(ExperianceDto dto);

	List<ExperianceDto> getExperiance(Long userId);

}
