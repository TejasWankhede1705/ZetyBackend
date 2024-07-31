package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "besic_details")
@Getter
@Setter
@NoArgsConstructor
public class BesicDetails extends BaseEntity {

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "email")
	@Email
	private String email;

	@Column(name = "phone", length = 10)
	private String phone;

	@Column(name = "profession")
	private String Profession;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;

	@Column(name = "linkdin")
	private String linkdin;

	@Column(name = "github")
	private String github;

	@OneToMany(mappedBy = "detailsEducation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Education> education = new ArrayList<>();

	@OneToMany(mappedBy = "detailsExperiance", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Experiance> experiance = new ArrayList<>();

	@OneToMany(mappedBy = "detailsSkill", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Skill> skills = new ArrayList<>();

	// helper methods
	public void addEducation(Education e) {
		education.add(e);
		e.setDetailsEducation(this);
	}

	public void removeEducation(Education e) {
		education.remove(e);
		e.setDetailsEducation(null);
	}

	// helper method for experiance
	public void addExperance(Experiance e) {
		experiance.add(e);
		e.setDetailsExperiance(this);
	}

	public void removeExperiance(Experiance e) {
		experiance.remove(e);
		e.setDetailsExperiance(null);
	}
	
	//helper method for Skills
	public void addSkill(Skill s) {
		skills.add(s);
		s.setDetailsSkill(this);
	}
	public void removeSkill(Skill s) {
		skills.remove(s);
		s.setDetailsSkill(null);
	}

	public BesicDetails(String firstName, String lastName, @Email String email, String phone, String profession,
			String city, String country, String linkdin, String github) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.Profession = profession;
		this.city = city;
		this.country = country;
		this.linkdin = linkdin;
		this.github = github;
	}

	@Override
	public String toString() {
		return "BesicDetails [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone="
				+ phone + ", Profession=" + Profession + ", city=" + city + ", country=" + country + ", linkdin="
				+ linkdin + ", github=" + github + "]";
	}

}
