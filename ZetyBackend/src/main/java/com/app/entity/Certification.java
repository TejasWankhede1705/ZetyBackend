package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "certification")
public class Certification extends BaseEntity {

	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "education_id")
	private Education education;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}
	
	

}
