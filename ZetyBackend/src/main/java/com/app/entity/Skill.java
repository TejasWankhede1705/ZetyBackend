package com.app.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skills")
public class Skill extends BaseEntity {

    @ElementCollection
    @CollectionTable(name = "skills_list", joinColumns = @JoinColumn(name = "skill_id"))
    @Column(name = "skill")
    private List<String> skills;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_type")
    private SkillType skillType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private BesicDetails detailsSkill;
    
    private String languages;

    public Skill() {}
    
	public Skill(List<String> skills, SkillType skillType, String languages) {
		super();
		this.skills = skills;
		this.skillType = skillType;
		this.languages = languages;
	}

	public List<String> getSkills() {
		return skills;
	}
	
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public BesicDetails getDetailsSkill() {
		return detailsSkill;
	}

	public void setDetailsSkill(BesicDetails detailsSkill) {
		this.detailsSkill = detailsSkill;
	}

	public String getLanguages() {
		return languages;
	}


	public void setLanguages(String languages) {
		this.languages = languages;
	}


	@Override
	public String toString() {
		return "Skill [skills=" + skills + ", skillType=" + skillType + ", detailsSkill=" + detailsSkill
				+ ", languages=" + languages + "]";
	}

}
