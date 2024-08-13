package com.app.entity;

import java.util.List;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project extends BaseEntity {

	@Column(name = "title")
	private String ProjectTitle;

	@Column(name = "role")
	private String ProjectRole;

	@ElementCollection
	@CollectionTable(name = "techStacks", joinColumns = @JoinColumn(name = "project_id"))

	private List<String> Techstack;

	@Column(name = "link")
	private String ProjectLink;

	@Column(name = "description")
	private String Description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private BesicDetails detailsProject;

	public Project(String projectTitle, String projectRole, List<String> techstack, String projectLink,
			String description, BesicDetails detailsProject) {
		super();
		ProjectTitle = projectTitle;
		ProjectRole = projectRole;
		Techstack = techstack;
		ProjectLink = projectLink;
		Description = description;
		this.detailsProject = detailsProject;
	}

	public Project() {
		super();
	}

	public String getProjectTitle() {
		return ProjectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		ProjectTitle = projectTitle;
	}

	public String getProjectRole() {
		return ProjectRole;
	}

	public void setProjectRole(String projectRole) {
		ProjectRole = projectRole;
	}

	public List<String> getTechstack() {
		return Techstack;
	}

	public void setTechstack(List<String> techstack) {
		Techstack = techstack;
	}

	public String getProjectLink() {
		return ProjectLink;
	}

	public void setProjectLink(String projectLink) {
		ProjectLink = projectLink;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public BesicDetails getDetailsProject() {
		return detailsProject;
	}

	public void setDetailsProject(BesicDetails detailsProject) {
		this.detailsProject = detailsProject;
	}

	@Override
	public String toString() {
		return "Project [ProjectTitle=" + ProjectTitle + ", ProjectRole=" + ProjectRole + ", Techstack=" + Techstack
				+ ", ProjectLink=" + ProjectLink + ", Description=" + Description + "]";
	}
	
	

}