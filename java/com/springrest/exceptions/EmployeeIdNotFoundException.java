package com.springrest.exceptions;

public class EmployeeIdNotFoundException extends RuntimeException{

	public EmployeeIdNotFoundException(String message) {
		super(message);
	}
}
