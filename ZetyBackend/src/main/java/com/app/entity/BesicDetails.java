package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "besic_details")
public class BesicDetails extends BaseEntity {

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

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
	
	@Column(name="message")
	private String message;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "detailsEducation", cascade = CascadeType.ALL, orphanRemoval = true)
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
	
	public BesicDetails() {}
	
	public BesicDetails(String first_name, String last_name, @Email String email, String phone, String profession,
			String city, String country, String linkdin, String github, String message, List<Education> education,
			List<Experiance> experiance, List<Skill> skills) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		Profession = profession;
		this.city = city;
		this.country = country;
		this.linkdin = linkdin;
		this.github = github;
		this.message = message;
		this.education = education;
		this.experiance = experiance;
		this.skills = skills;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfession() {
		return Profession;
	}

	public void setProfession(String profession) {
		Profession = profession;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLinkdin() {
		return linkdin;
	}

	public void setLinkdin(String linkdin) {
		this.linkdin = linkdin;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	public List<Experiance> getExperiance() {
		return experiance;
	}

	public void setExperiance(List<Experiance> experiance) {
		this.experiance = experiance;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BesicDetails [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", phone="
				+ phone + ", Profession=" + Profession + ", city=" + city + ", country=" + country + ", linkdin="
				+ linkdin + ", github=" + github + ", message=" + message + ", education=" + education + ", experiance="
				+ experiance + ", skills=" + skills + "]";
	}

}
