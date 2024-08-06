package com.app.dto;



import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BesicDetailsDto {

	  private String first_name;  // Change to match database
	    private String last_name;   // Change to match database
	    private String email;
	    private String phone;
	    private String profession;
	    private String city;
	    private String country;
	    private String linkdin;     // Keep as is for now, but check consistency
	    private String github;
	   
		public BesicDetailsDto() {}
		
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
			return profession;
		}
		public void setProfession(String profession) {
			this.profession = profession;
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

		

		@Override
		public String toString() {
			return "BesicDetailsDto [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
					+ ", phone=" + phone + ", profession=" + profession + ", city=" + city + ", country=" + country
					+ ", linkdin=" + linkdin + ", github=" + github +  "]";
		}

		
		
	    
   
}