package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Education;

public interface EducationDao extends JpaRepository<Education, Long> {

//	@Query("SELECT e.certifications FROM Education e WHERE e.id = :id")
//    List<String> findCertificationsByEducationId(@Param("id") Long id);
}
