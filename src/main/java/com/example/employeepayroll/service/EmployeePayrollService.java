package com.example.employeepayroll.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeepayroll.Repository.EmployeePayrollRepository;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.exception.EmployeePayrollCustomException;
import com.example.employeepayroll.model.Employee;


import jakarta.validation.Valid;
// This class is use for business logic
@Service
public class EmployeePayrollService {
	
	//The @Autowired annotation can be used to autowire bean on the setter method 
	// Here create the bean EmployeePayrollRepository 
	@Autowired
	EmployeePayrollRepository employeePayrollRepository;

	public Employee addEmployee(EmployeeDTO employee) {
		
		Employee employeeData = new Employee(employee);
		return employeePayrollRepository.save(employeeData);
	}

	public List<Employee> getAllEmployee() {
		return employeePayrollRepository.findAll();
	}

	public Employee getEmployeeById(int id) {
		return employeePayrollRepository.findById(id)
				.orElseThrow(() -> new EmployeePayrollCustomException("Employee with id:"+id+" not found"));
	}

	

	public void DeleteEmployee(int id) {
		Employee employee_Data = getEmployeeById(id);
		if(employee_Data != null) {
		
			employeePayrollRepository.deleteById(id);
		}
	}

	public Employee updateEmployee(int id, EmployeeDTO employee) {
	
		Employee employee_Data = getEmployeeById(id);
		if(employee_Data != null) {
			employee_Data.setFName(employee.fName);
			employee_Data.setLName(employee.lName);
			employee_Data.setMobileNo(employee.mobileNo);
			employee_Data.setSallary(employee.sallary);
			return employeePayrollRepository.save(employee_Data);
			
		}
		return null;
	}

}
