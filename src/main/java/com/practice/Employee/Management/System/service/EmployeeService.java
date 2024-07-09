package com.practice.Employee.Management.System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.Employee.Management.System.Entity.Employee;
import com.practice.Employee.Management.System.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployee(int id) {
		Optional<Employee> employees=employeeRepository.findById(id);
		if(employees.isPresent()) {
		return employees.get();
	}
		else
			return null;
	}
public List<Employee> getAllEmployee(Employee employee) {
	return employeeRepository.findAll();
}

public Employee updateEmployee(int id, Employee employee) {
	Employee existingEmployee=getEmployee(id);
	if(existingEmployee !=null)
	{
		existingEmployee.setName(employee.getName());
		existingEmployee.setContact_number(employee.getContact_number());
		existingEmployee.setSal(employee.getSal());
	
	return employeeRepository.save(existingEmployee);
}
	return null;
}
public Boolean deleteEmployee(int id) {
	Employee employee=getEmployee(id);
	if(employee != null)
	{
		employeeRepository.delete(employee);
		return true;
	}
	else
    return false;
}
}
