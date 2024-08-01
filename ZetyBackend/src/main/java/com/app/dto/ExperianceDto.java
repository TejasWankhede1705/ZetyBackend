package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExperianceDto {

	private Long UserId;
	
	private String Title;
	
	
	private String Company;
	
	
	private String Location;
	

	private LocalDate StartDate;
	

	private LocalDate EndDate;
	
}
