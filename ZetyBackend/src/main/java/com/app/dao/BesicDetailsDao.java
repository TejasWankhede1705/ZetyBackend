package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.BesicDetails;

<<<<<<< HEAD
public interface BesicDetailsDao extends JpaRepository<BesicDetails, Long>  {
	
=======
public interface BesicDetailsDao extends JpaRepository<BesicDetails, Long>{
	boolean addBasicDetails(BesicDetails basicDetails);
    List<BesicDetails> getAllBasicDetails();
    BesicDetails getBasicDetailsById(Long id); // Method to get basic details by ID
>>>>>>> fc14205f8127f4f9790d4e14b4de7f1074e58137
    


}
