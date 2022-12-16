package com.springrest.exceptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(EmployeeIdNotFoundException.class)
	public String handleException(EmployeeIdNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleException(MethodArgumentNotValidException ex)
	{
		Map<String,String> map=new LinkedHashMap<>();
		List<ObjectError> oerrors=ex.getAllErrors();
		oerrors.forEach(obj->{
			FieldError fe=(FieldError)obj;
			String fname=fe.getField();
			String ferrorMsg=fe.getDefaultMessage();
			map.put(fname, ferrorMsg);
		});
		return map;
	}
}
