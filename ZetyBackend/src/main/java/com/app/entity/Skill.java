package com.app.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
public class Skill extends BaseEntity{

	
	@ElementCollection
	@CollectionTable(name = "primary_skills", joinColumns = @JoinColumn(name = "skill_id"))
	@Column(name = "skill")
	private List<String> primarySkills;

	@ElementCollection
	@CollectionTable(name = "secondary_skills", joinColumns = @JoinColumn(name = "skill_id"))
	@Column(name = "skill")
	private List<String> secondarySkills;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private BesicDetails detailsSkill;

	public Skill(List<String> primarySkills, List<String> secondarySkills) {
		super();
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
	}

	@Override
	public String toString() {
		return "Skill [primarySkills=" + primarySkills + ", secondarySkills=" + secondarySkills + "]";
	}
	
	
}
