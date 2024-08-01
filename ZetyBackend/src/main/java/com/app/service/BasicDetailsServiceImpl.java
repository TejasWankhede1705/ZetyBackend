package com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BesicDetailsDao;
import com.app.dto.BesicDetailsDto;
import com.app.entity.BesicDetails;
import com.app.service.BasicDetailsService;

@Service
@Transactional
public class BasicDetailsServiceImpl implements BasicDetailsService {

    @Autowired
    private BesicDetailsDao dao;

    @Override
    public boolean addBasicDetails(BesicDetails basicDetails) {
        return dao.addBasicDetails(basicDetails);
    }

    @Override
    public List<BesicDetails> getAllBasicDetails() {
        return dao.getAllBasicDetails();
    }

    @Override
    public BesicDetails getBasicDetailsById(Long id) {
        BesicDetails basicDetails = dao.getBasicDetailsById(id);
        return convertToDTO(basicDetails);
    }

    // Method to convert BesicDetails to BesicDetailsDTO
    private BesicDetails convertToDTO(BesicDetails besicDetails) {
        return new BesicDetails(
                besicDetails.getId(),
                besicDetails.getFirstName(),
                besicDetails.getLastName(),
                besicDetails.getEmail(),
                besicDetails.getProfession(),
                besicDetails.getCity(),
                besicDetails.getCountry(),
                besicDetails.getLinkdin(),
                besicDetails.getGithub(),
                besicDetails.getPhone()
        );
    }
}
