package com.app.dto;

import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BesicDetailsDto {

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private String Profession;

	private String city;

	private String country;

	private String linkdin;

	private String github;
}