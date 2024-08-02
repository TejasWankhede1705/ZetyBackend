package com.app.dto;





import com.app.entity.Degree;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter

@NoArgsConstructor
public class EducationDto {


	private Long Id;
	
	private String SchoolName;

	
	private String SchoolLocation;
	
	
	private String FieldOfStudy;
	
	
	private String graduationYear;
	
	
	private Degree degree;


}
