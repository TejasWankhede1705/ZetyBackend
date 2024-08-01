package com.app.service;

import java.util.List;

import com.app.entity.BesicDetails;

public interface BasicDetailsService {
	 boolean addBasicDetails(BesicDetails basicDetails);
	    List<BesicDetails> getAllBasicDetails();
	    BesicDetails  getBasicDetailsById(Long id); // Method to get basic details by ID


}
