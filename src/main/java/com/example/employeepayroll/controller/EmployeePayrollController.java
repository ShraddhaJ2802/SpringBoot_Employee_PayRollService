package com.example.employeepayroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.service.EmployeePayrollService;

import jakarta.validation.Valid;

@RestController
public class EmployeePayrollController {
	//To create the dependency injection of EmployeePayrollService
	@Autowired
	EmployeePayrollService employeePayrollService;
	
	//To save data in database with url is /add with to check validate employee
	
	@PostMapping("/add")
	 public Employee addEmployee(@Valid @RequestBody EmployeeDTO employee)
	 {
		Employee employeeData = employeePayrollService.addEmployee(employee);
		return employeeData;
	 }
	
	//Display the all employee list with url is /getallEmployee
	
	@GetMapping("/getallEmployee")
	public List<Employee> getAllEmployee()
	{
		return employeePayrollService.getAllEmployee();
	}
	
	//Display the employee with employee id with url is /get/{id}
	
	@GetMapping("/get/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		return employeePayrollService.getEmployeeById(id);
	}
	
	//Some changes in employee by passing parmeter employee id with url is /update/{id}
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable int id , @RequestBody EmployeeDTO employee )
	{
		return employeePayrollService.updateEmployee(id,employee);
	}
	
	//Delete the employee by passing 
	@DeleteMapping("/delete/{id}")
	public void DeleteEmployee(@PathVariable int id  )
	{
		employeePayrollService.DeleteEmployee(id);
	}

}
