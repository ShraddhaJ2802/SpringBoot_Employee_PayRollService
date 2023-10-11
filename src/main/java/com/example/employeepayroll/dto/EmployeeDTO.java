package com.example.employeepayroll.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EmployeeDTO {
	
	@NotEmpty(message = "Employee name cannot be null")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$",message = "Employee name Invalid ")
	public String fName;
	
	@NotEmpty(message = "Employee last name cannot be null")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$",message = "Employee last name Invalid ")
	public String lName;
	
	@Pattern(regexp = "male|female", message = "Gender needs to be male or female")
	public String gender;
	
	@NotBlank(message = "Employee profilepic cannot be empty")
	public String profilepic;
	
	@Min(value = 500, message = "Min Wage should be more than 500")
	public double sallary;
	
	@NotBlank(message = "Employee department cannot be empty")
	public String dept;
	
	@NotBlank(message = "Employee notes cannot be empty")
	public String notes;
	
	@NotEmpty(message = "Employee phone no cannot be null")
	@Pattern(regexp = "^[0-9]{10}$",message = "Employee phone no invalid Invalid ")
	//+91 9136812895
	public String mobileNo;

}
