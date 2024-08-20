package com.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor

public class User extends BaseEntity {

	@Column(name = "email", length = 100)
	@Email(message = "Email should be valid")
	@NotEmpty(message = "Email cannot be empty")
	private String email;

	@Column(name = "password")
	private String password;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private BesicDetails besicDetails;

	public User() {
	}

}
