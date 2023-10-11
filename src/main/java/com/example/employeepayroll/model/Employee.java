package com.example.employeepayroll.model;

import com.example.employeepayroll.dto.EmployeeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Table(name="Employee_Payroll")
@Data
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	private String fName;
	private String lName;
	private String gender;
	private String profilepic;
	private double sallary;
	private String dept;
	private String notes;
	private String mobileNo;
	
	
	public Employee(EmployeeDTO employeeDTO) {
		
		this.fName = employeeDTO.fName;
		this.lName = employeeDTO.lName;
		this.gender =employeeDTO. gender;
		this.profilepic = employeeDTO.profilepic;
		this.sallary = employeeDTO.sallary;
		this.dept = employeeDTO.dept;
		this.notes = employeeDTO.notes;
		this.mobileNo = employeeDTO.mobileNo;
	}
	
}
