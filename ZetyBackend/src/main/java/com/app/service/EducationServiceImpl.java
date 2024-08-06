package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.EducationDto;
import com.app.entity.BesicDetails;
import com.app.entity.Education;
import com.app.dao.BesicDetailsDao;
import com.app.dao.EducationDao;
import com.app.custum_exception.RersourseNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EducationServiceImpl implements EducationSerivce {

    private static final Logger logger = LoggerFactory.getLogger(EducationServiceImpl.class);

    @Autowired
    private EducationDao educationDao;

    @Autowired
    private BesicDetailsDao besicDetailsDao;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ApiResponse addEducation(EducationDto dto) {
        logger.info("Adding education details for user ID: {}", dto.getUserId());

        // Check if userId is present in the DTO
        if (dto.getUserId() == null) {
            logger.error("User ID is null in EducationDto");
            throw new IllegalArgumentException("User ID cannot be null");
        }

        // Map DTO to Education entity
        Education education = mapper.map(dto, Education.class);

        // Fetch BasicDetails using userId from DTO
        BesicDetails basicDetails = besicDetailsDao.findById(dto.getUserId())
                .orElseThrow(() -> new RersourseNotFoundException("User not found"));

        // Set the fetched BasicDetails to the Education entity
        education.setDetailsEducation(basicDetails);
        
        // Save the Education entity
        educationDao.save(education);

        logger.info("Education details added successfully for user ID: {}", dto.getUserId());
        return new ApiResponse("Education details added successfully");
    }

    @Override
    public List<EducationDto> getEducation(Long userId) {
        logger.info("Fetching education details for user ID: {}", userId);

        BesicDetails basicDetails = besicDetailsDao.findById(userId)
                .orElseThrow(() -> new RersourseNotFoundException("Education Not Found"));

        // Ensure you set userId from BesicDetails
        List<EducationDto> educationList = basicDetails.getEducation().stream()
                .map(education -> {
                    EducationDto dto = mapper.map(education, EducationDto.class);
                    dto.setUserId(basicDetails.getId()); // Set userId from BesicDetails
                    return dto;
                })
                .collect(Collectors.toList());

        logger.info("Fetched {} education records for user ID: {}", educationList.size(), userId);
        return educationList;
    }
}
