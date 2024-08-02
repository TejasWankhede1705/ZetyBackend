package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.EducationDto;

public interface EducationSerivce {

	ApiResponse addEducation(EducationDto Dto);
	
<<<<<<< HEAD
	List<EducationDto> getEducation(Long userId);
=======
	List<EducationDto> getEducation(Long EducationId);
>>>>>>> fc14205f8127f4f9790d4e14b4de7f1074e58137
}
