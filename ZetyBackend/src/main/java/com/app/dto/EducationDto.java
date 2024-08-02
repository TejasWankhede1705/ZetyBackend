package com.app.dto;

<<<<<<< HEAD



import com.app.entity.Degree;

import lombok.Getter;
import lombok.NoArgsConstructor;
=======
import java.time.LocalDate;

import com.app.entity.Education;

import lombok.Getter;
>>>>>>> fc14205f8127f4f9790d4e14b4de7f1074e58137
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
<<<<<<< HEAD
@NoArgsConstructor
public class EducationDto {


	private Long Id;
	
	private String SchoolName;

	
	private String SchoolLocation;
	
	
	private String FieldOfStudy;
	
	
	private String graduationYear;
	
	
	private Degree degree;
	
=======
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
>>>>>>> fc14205f8127f4f9790d4e14b4de7f1074e58137
	

}
