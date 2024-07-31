package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="education")
@Getter
@Setter
@NoArgsConstructor
public class Education extends BaseEntity{

	@Column(name = "school_name")
	private String SchoolName;

	@Column(name = "schooll_ocation")
	private String SchoolLocation;
	
	@Column(name = "filed_of_study")
	private String FieldOfStudy;
	
	@Column(name = "graduation_Year")
	private String graduationYear;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "degree")
	private Degree degree;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",nullable=false)
	private BesicDetails detailsEducation;


	public Education(String schoolName, String schoolLocation, String fieldOfStudy, String graduationYear,
			Degree degree) {
		super();
		SchoolName = schoolName;
		SchoolLocation = schoolLocation;
		FieldOfStudy = fieldOfStudy;
		this.graduationYear = graduationYear;
		this.degree = degree;
	}
	
	
	
}
