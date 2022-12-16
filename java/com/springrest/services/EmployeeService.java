package com.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.beans.Employee;
import com.springrest.repository.EmployeeRepository;
@Service("es")
public class EmployeeService {
	@Autowired
	private EmployeeRepository er;
	
	public String insertEmp(Employee emp)
	{
		return er.addEmployee(emp);
	}
	public List<Employee> fetchAllEmp()
	{
		return er.fetchAll();
	}
	public String updateEmp(Employee emp)
	{
		return er.updateEmployee(emp);
	}
	public String deleteEmp(int id)
	{
		return er.deleteEmpById(id);
	}
	public Employee fetchById(int id)
	{
		return er.fetchEmployeeById(id);
	}
}
