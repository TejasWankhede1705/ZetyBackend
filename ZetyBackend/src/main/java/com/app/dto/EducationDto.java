package com.app.dto;

import com.app.entity.BesicDetails;
import com.app.entity.Degree;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class EducationDto {

	private Long Id;
	
	private String SchoolName;

	
	private String SchoolLocation;
	
	
	private String FieldOfStudy;
	
	
	private String graduationYear;
	
	
	private Degree degree;

    private Long userId; // to hold the user ID for association


	
	public EducationDto() {
		super();
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getSchoolName() {
		return SchoolName;
	}


	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}


	public String getSchoolLocation() {
		return SchoolLocation;
	}


	public void setSchoolLocation(String schoolLocation) {
		SchoolLocation = schoolLocation;
	}


	public String getFieldOfStudy() {
		return FieldOfStudy;
	}


	public void setFieldOfStudy(String fieldOfStudy) {
		FieldOfStudy = fieldOfStudy;
	}


	public String getGraduationYear() {
		return graduationYear;
	}


	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}


	public Degree getDegree() {
		return degree;
	}


	public void setDegree(Degree degree) {
		this.degree = degree;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}
	



	@Override
	public String toString() {
		return "EducationDto [Id=" + Id + ", SchoolName=" + SchoolName + ", SchoolLocation=" + SchoolLocation
				+ ", FieldOfStudy=" + FieldOfStudy + ", graduationYear=" + graduationYear + ", degree=" + degree
				+ ", userId=" + userId +  "]";
	}


	
	

}
