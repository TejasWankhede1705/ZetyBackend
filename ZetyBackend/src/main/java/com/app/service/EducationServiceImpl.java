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

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
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
        logger.info("DTO isGapTaken: {}", dto.isGapTaken());        
        if (dto.getUserId() == null) {
            logger.error("User ID is null in EducationDto");
            throw new IllegalArgumentException("User ID cannot be null");
        }
        
        Education education = mapper.map(dto, Education.class);
        logger.info("Mapped Education isGapTaken: {}", education.isGapTaken());
        BesicDetails basicDetails = besicDetailsDao.findById(dto.getUserId())
                .orElseThrow(() -> new RersourseNotFoundException("User not found"));
        education.setDetailsEducation(basicDetails);
        educationDao.save(education);

        logger.info("Education details added successfully for user ID: {}", dto.getUserId());
        return new ApiResponse("Education details added successfully");
    }

    @Override
    public List<EducationDto> getEducation(Long userId) {
        logger.info("Fetching education details for user ID: {}", userId);

        BesicDetails basicDetails = besicDetailsDao.findById(userId)
                .orElseThrow(() -> new RersourseNotFoundException("Education Not Found"));

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

    @Override
    public ApiResponse updateEducation(Long id, EducationDto dto) {
        logger.info("Updating education details for education ID: {}", id);
        Education existingEducation = educationDao.findById(id)
            .orElseThrow(() -> new RersourseNotFoundException("Education not found for ID: " + id));

        dto.setId(existingEducation.getId());
        logger.info("Before update: {}", existingEducation.isGapTaken());
        mapper.map(dto, existingEducation);
        logger.info("After update: {}", existingEducation.isGapTaken());
        educationDao.save(existingEducation);
        logger.info("Education details updated successfully for education ID: {}", id);

        return new ApiResponse("Education details updated successfully");
    }

}
