package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.BesicDetails;

public interface BesicDetailsDao extends JpaRepository<BesicDetails, Long> {
    boolean addBasicDetails(BesicDetails basicDetails);
    List<BesicDetails> getAllBasicDetails();
    BesicDetails getBasicDetailsById(Long id); // Method to get basic details by ID
}
