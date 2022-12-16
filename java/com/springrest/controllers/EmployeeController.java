package com.springrest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.beans.Employee;
import com.springrest.exceptions.EmployeeIdNotFoundException;
import com.springrest.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService es;
	
	@GetMapping(value="/employees")
	public List<Employee> getAll()
	{
		return es.fetchAllEmp();
	}
	@PostMapping("/employees")
	public String addEmployee(@Valid @RequestBody Employee emp)
	{
		return es.insertEmp(emp);
	}
	@PutMapping("/employees/{id}")
	public String updateEmployee(@Valid @RequestBody Employee emp,@PathVariable("id") int id)
	{
		if(emp.getEid()==id)
			return es.updateEmp(emp);
		else
			return "Id doesn't Match";
	}
	@DeleteMapping("/employees/{eid}")
	public String deleteEmployee(@PathVariable("eid") int id)
	{
		return es.deleteEmp(id);
	}
	@GetMapping("/employees/{eid}")
	public Employee fetchById(@PathVariable("eid") int id)
	{
		return es.fetchById(id);
	}
	/*@ExceptionHandler(Exception.class)
	public String handleException1(Exception ex)
	{
		return "General Catch Block : "+ex.getMessage();
	}
	@ExceptionHandler(RuntimeException.class)
	public String handleException2(RuntimeException ex)
	{
		return "Runtime Catch Block : "+ex.getMessage();
	}
	@ExceptionHandler(EmployeeIdNotFoundException.class)
	public String handleException(EmployeeIdNotFoundException ex)
	{
		return ex.getMessage();
	}*/
}
