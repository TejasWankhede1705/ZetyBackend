package com.app.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
	
	@Enumerated(EnumType.STRING)
	@Column(name="month")
	private Months month;
	
    @Column(name = "is_gap_taken")
	private boolean isGapTaken;
    
    @Column(name = "gap_year")
	private String gapYear;
	
	@ElementCollection
	@CollectionTable(name = "certification", joinColumns = @JoinColumn(name = "education_id"))
	@Column(name = "certification_name")
	private List<String> certification;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id",nullable=false)
	private BesicDetails detailsEducation;
	
	public Education() {}
	
	public Education(String schoolName, String schoolLocation, String fieldOfStudy, String graduationYear,
			Degree degree, Months month, boolean isGapTaken, String gapYear, List<String> certification,
			BesicDetails detailsEducation) {
		SchoolName = schoolName;
		SchoolLocation = schoolLocation;
		FieldOfStudy = fieldOfStudy;
		this.graduationYear = graduationYear;
		this.degree = degree;
		this.month = month;
		this.isGapTaken = isGapTaken;
		this.gapYear = gapYear;
		this.certification = certification;
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

	public Months getMonth() {
		return month;
	}

	public void setMonth(Months month) {
		this.month = month;
	}
	
	public boolean isGapTaken() {
		return isGapTaken;
	}

	public void setGapTaken(boolean isGapTaken) {
		this.isGapTaken = isGapTaken;
	}

	public String getGapYear() {
		return gapYear;
	}

	public void setGapYear(String gapYear) {
		this.gapYear = gapYear;
	}

	public List<String> getCertification() {
		return certification;
	}

	public void setCertification(List<String> certification) {
		this.certification = certification;
	}

	@Override
	public String toString() {
		return "Education [id=" + id + ", SchoolName=" + SchoolName + ", SchoolLocation=" + SchoolLocation
				+ ", FieldOfStudy=" + FieldOfStudy + ", graduationYear=" + graduationYear + ", degree=" + degree
				+ ", month=" + month + ", isGapTaken=" + isGapTaken + ", gapYear=" + gapYear + ", certification="
				+ certification + ", detailsEducation=" + detailsEducation + "]";
	}

}
