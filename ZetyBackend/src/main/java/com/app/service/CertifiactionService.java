package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.CertificationDto;

public interface CertifiactionService {

	ApiResponse addCertification(CertificationDto dto);

	CertificationDto getCertification(Long id);

	ApiResponse updateCertification(Long id, CertificationDto dto);

	ApiResponse deleteCertification(Long certificationId);

	List<CertificationDto> getAllCertificationDetails(Long educationId);

}
