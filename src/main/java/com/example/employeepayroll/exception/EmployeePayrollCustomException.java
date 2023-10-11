package com.example.employeepayroll.exception;

//To create the custom exception class to handle the exception and this class extends the RuntimeException
public class EmployeePayrollCustomException extends RuntimeException {
	
	public EmployeePayrollCustomException(String message) {
		super(message);
	
	}


}
