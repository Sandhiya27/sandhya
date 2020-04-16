package com.nttdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Usertable")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@NotEmpty
	@Pattern(regexp="[^0-9]+")
	@Size(min=6,max=20)
	@Column(name = "Username")
	private String UserName;
	
	@NotEmpty
	@Column(name = "gender")
	private String gender;
	
	@Size(min=1)
	@NotNull
	@Column(name = "course")
	private String course;
	
	@NotEmpty
	@Column(name = "Location")
	private String Location;
	
	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;
	
	@NotEmpty
	@Column(name = "pwd")
	private String pwd;
	
	@NotNull
	@Min(value = 1000000000)
	@Column(name = "mobile")
	private Long mobile;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCity() {
		return Location;
	}

	public void setCity(String city) {
		this.Location = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return pwd;
	}

	public void setPassword(String password) {
		this.pwd = password;
	}

	public void setPhone(Long phone) {
		this.mobile = phone;
	}

	public Long getPhone() {
		return mobile;
	}
	
	public String getTechnology() {
		return course;
	}
	public void setTechnology(String technology) {
		this.course = technology;
	}
}
