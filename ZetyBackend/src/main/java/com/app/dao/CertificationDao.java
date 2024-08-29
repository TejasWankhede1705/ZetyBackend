package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Certification;

public interface CertificationDao extends JpaRepository<Certification, Long> {

}
