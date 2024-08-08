package com.app.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "experiance")
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

	@ElementCollection
	@CollectionTable(name = "responsibility", joinColumns = @JoinColumn(name = "experience_id"))
	@Column(name = "responsibility")
	private List<String> responsibility ;
	
	public Experiance() {}

	public Experiance(String title, String company, String location, LocalDate startDate, LocalDate endDate,
			BesicDetails detailsExperiance, List<String> responsibility) {
		Title = title;
		Company = company;
		Location = location;
		StartDate = startDate;
		EndDate = endDate;
		this.detailsExperiance = detailsExperiance;
		this.responsibility = responsibility;
	}

	public String getTitle() {
		return Title;
	}
	
	public void setTitle(String title) {
		Title = title;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
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

	public BesicDetails getDetailsExperiance() {
		return detailsExperiance;
	}

	public void setDetailsExperiance(BesicDetails detailsExperiance) {
		this.detailsExperiance = detailsExperiance;
	}

	public List<String> getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(List<String> responsibility) {
		this.responsibility = responsibility;
	}

	@Override
	public String toString() {
		return "Experiance [Title=" + Title + ", Company=" + Company + ", Location=" + Location + ", StartDate="
				+ StartDate + ", EndDate=" + EndDate + ", detailsExperiance=" + detailsExperiance + ", responsibility="
				+ responsibility + "]";
	}
}
