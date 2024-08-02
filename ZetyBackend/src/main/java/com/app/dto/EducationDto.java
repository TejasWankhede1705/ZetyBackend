package com.app.dto;

import java.time.LocalDate;

import com.app.entity.Education;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EducationDto {

	private Long EducationId;

	private String CollegeName;
	
	private String UniversityName;
	
	private String CGPA;
	
	private String Location;
	
	private LocalDate StartDate;
	
	private LocalDate EndDate;

	public Long getEducationId() {
		return EducationId;
	}

	public void setEducationId(Long educationId) {
		EducationId = educationId;
	}

	public String getCollegeName() {
		return CollegeName;
	}

	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}

	public String getUniversityName() {
		return UniversityName;
	}

	public void setUniversityName(String universityName) {
		UniversityName = universityName;
	}

	public String getCGPA() {
		return CGPA;
	}

	public void setCGPA(String cGPA) {
		CGPA = cGPA;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public LocalDate getStartDate() {
		return StartDate;
	}

	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}

	public LocalDate getEndDate() {
		return EndDate;
	}

	public void setEndDate(LocalDate endDate) {
		EndDate = endDate;
	}
	

}
