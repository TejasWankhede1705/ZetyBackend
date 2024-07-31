package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "experiance")
@Getter
@Setter
@NoArgsConstructor
public class Experiance extends BaseEntity {
	
	
	@Column(name = "title")
	private String Title;
	
	@Column(name = "company")
	private String Company;
	
	@Column(name = "location")
	private String Location;
	
	@Column(name = "startdate")
	private LocalDate StartDate;
	
	@Column(name = "enddate")
	private LocalDate EndDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",nullable=false)
	private BesicDetails detailsExperiance ;

	public Experiance(String title, String company, String location, LocalDate startDate, LocalDate endDate) {
		super();
		Title = title;
		Company = company;
		Location = location;
		StartDate = startDate;
		EndDate = endDate;
	}

	@Override
	public String toString() {
		return "Experiance [Title=" + Title + ", Company=" + Company + ", Location=" + Location + ", StartDate="
				+ StartDate + ", EndDate=" + EndDate + "]";
	}

	
}
