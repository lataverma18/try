package com.springmvc.init;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springrest.beans.Employee;


@Configuration
@ComponentScan(basePackages= {"com.springrest.controllers","com.springrest.services","com.springrest.repository","com.springrest.exceptions"})
@EnableWebMvc
public class MyConfig {
	@Bean("emps")
	public List<Employee> emps()
	{
		List<Employee> emps=new ArrayList<>();
		emps.add(new Employee(101,"Ronit",34000));
		emps.add(new Employee(102,"Raj",45000));
		emps.add(new Employee(103,"Jyoti",42000));
		emps.add(new Employee(104,"Neha",50000));
		return emps;
	}
}
