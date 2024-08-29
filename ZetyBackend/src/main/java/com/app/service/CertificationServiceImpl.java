package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.CertificationDao;
import com.app.dao.EducationDao;
import com.app.dto.ApiResponse;
import com.app.dto.CertificationDto;

import com.app.entity.Certification;
import com.app.entity.Education;

@Service
@Transactional
public class CertificationServiceImpl implements CertifiactionService {

	@Autowired
	private EducationDao educationDao;

	@Autowired
	private CertificationDao certificationDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addCertification(CertificationDto dto) {

		Education e = educationDao.findById(dto.getEducaionId())
				.orElseThrow(() -> new RersourseNotFoundException("education details cannot be found for the id"));

		Certification c = mapper.map(dto, Certification.class);

		e.addCertification(c);
		certificationDao.save(c);
		return new ApiResponse("certification details added sucsessfully !");
	}

	@Override
	public CertificationDto getCertification(Long id) {
		Certification c = certificationDao.findById(id)
				.orElseThrow(() -> new RersourseNotFoundException("Certification details cannot be found"));
		return mapper.map(c, CertificationDto.class);
	}

	@Override
	public ApiResponse updateCertification(Long id, CertificationDto dto) {
		// TODO Auto-generated method stub

		Certification c = certificationDao.findById(id)
				.orElseThrow(() -> new RersourseNotFoundException("Certification details cannot be found"));

		mapper.map(dto, c);
		certificationDao.save(c);
		return new ApiResponse("certification details updated sucsessfully");
	}

	@Override
	public ApiResponse deleteCertification(Long certificationId) {

		Certification c = certificationDao.findById(certificationId)
				.orElseThrow(() -> new RersourseNotFoundException("Certification details cannot be found"));

		Education e = educationDao.findById(c.getEducation().getId())
				.orElseThrow(() -> new RersourseNotFoundException("education details cannot be found"));

		certificationDao.delete(c);

		e.removeCertification(c);

		return new ApiResponse("certification details deleted sucsesffuly");
	}

	@Override
	public List<CertificationDto> getAllCertificationDetails(Long educationId) {

		Education e = educationDao.findById(educationId)
				.orElseThrow(() -> new RersourseNotFoundException("education details cannot be found for the id"));

		return e.getCertifications().stream().map(c -> mapper.map(c, CertificationDto.class))
				.collect(Collectors.toList());
	}

}
