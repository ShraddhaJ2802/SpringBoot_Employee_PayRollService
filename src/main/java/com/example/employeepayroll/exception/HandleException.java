package com.example.employeepayroll.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.employeepayroll.dto.ResponseDto;

//The@ControllerAdvice annotation allows us to consolidate our multiple, scattered 
//@ExceptionHandlers from before into a single, global error handling component.
@ControllerAdvice
public class HandleException {
	//Exception handler for incorrect data format
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException (MethodArgumentNotValidException exception)
	{
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream()
			 		.map(objectError -> objectError.getDefaultMessage())
			 		.collect(Collectors.toList());
		ResponseDto responseDto = new ResponseDto("Exception while processing REST Request",errMsg);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
	}
	
	//To handle the custom exception in application
	
	@ExceptionHandler(EmployeePayrollCustomException.class)
	   
	   public ResponseEntity<ResponseDto> handleUserCustomException(EmployeePayrollCustomException exception)
	   {
			ResponseDto responseDto = new ResponseDto("Exception while processing REST Request",exception.getMessage());
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);

	   }

}
