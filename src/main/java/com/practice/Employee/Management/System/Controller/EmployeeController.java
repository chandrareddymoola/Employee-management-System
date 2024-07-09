package com.practice.Employee.Management.System.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Employee.Management.System.Entity.Employee;
import com.practice.Employee.Management.System.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		 	return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}
	
	@GetMapping("/employee")
	public List<Employee> GetAllEmployess(@RequestBody Employee employee) {
		return employeeService.getAllEmployee(employee);
	}
	@PatchMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable int id, @ RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public Boolean deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}
}
