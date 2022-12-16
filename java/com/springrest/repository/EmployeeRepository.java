package com.springrest.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springrest.beans.Employee;
import com.springrest.exceptions.EmployeeIdNotFoundException;

@Repository("er")
public class EmployeeRepository {
	@Autowired
	private List<Employee> emps;

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public String addEmployee(Employee emp)
	{
		emps.add(emp);
		return "Added Successfully";
	}
	public String updateEmployee(Employee emp)
	{
		for(Employee e:emps)
		{
			if(e.getEid()==emp.getEid())
			{
				int index=emps.indexOf(e);
				emps.remove(index);
				emps.add(index,emp);
				return "Updated Successfully";
			}
		}
		throw new EmployeeIdNotFoundException("Employee not found for Id:"+ emp.getEid());
	}
	public Employee fetchEmployeeById(int id)
	{
		Optional<Employee> e=emps.stream().filter(obj->obj.getEid()==id).findAny();
		if(e.isPresent())
			return e.get();
		else
			throw new EmployeeIdNotFoundException("Employee not found for Id:"+ id);
	}
	public List<Employee> fetchAll()
	{
		return emps;
	}
	public String deleteEmpById(int id)
	{
		for(Employee e:emps)
		{
			if(e.getEid()==id)
			{
				int index=emps.indexOf(e);
				emps.remove(index);
				return "Deleted Successfully: " + id;
			}
		}
		throw new EmployeeIdNotFoundException("Employee not found for Id:"+ id);
	}
}
