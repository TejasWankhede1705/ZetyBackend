package com.app.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="education")
public class Education extends BaseEntity{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	@Column(name = "school_name")
	private String SchoolName;

	@Column(name = "schooll_ocation")
	private String SchoolLocation;
	
	@Column(name = "field_of_study")
	private String FieldOfStudy;
	
	@Column(name = "graduation_Year")
	private String graduationYear;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "degree")
	private Degree degree;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id",nullable=false)
	private BesicDetails detailsEducation;

	
	public Education() {}


	public Education( String schoolName, String schoolLocation, String fieldOfStudy, String graduationYear,
			Degree degree, BesicDetails detailsEducation) {
		SchoolName = schoolName;
		SchoolLocation = schoolLocation;
		FieldOfStudy = fieldOfStudy;
		this.graduationYear = graduationYear;
		this.degree = degree;
		this.detailsEducation = detailsEducation;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public BesicDetails getDetailsEducation() {
		return detailsEducation;
	}


	public void setDetailsEducation(BesicDetails detailsEducation) {
		this.detailsEducation = detailsEducation;
	}


	@Override
	public String toString() {
		return "Education [id=" + id + ", SchoolName=" + SchoolName + ", SchoolLocation=" + SchoolLocation
				+ ", FieldOfStudy=" + FieldOfStudy + ", graduationYear=" + graduationYear + ", degree=" + degree
				+ ", detailsEducation=" + detailsEducation + "]";
	}

	

}
