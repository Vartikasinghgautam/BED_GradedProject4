package com.vartika.employee.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vartika.employee.model.Employee;
import com.vartika.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	/*
	 * //data store private Set<Employee> employees = new HashSet<>();
	 */
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employee) {
		System.out.println("Saving the employee to the set....");
		Employee savedEmployee = this.employeeRepository.save(employee);
		return savedEmployee;
	}
	
	//method to return all the employees
	public Set<Employee> fetchAllEmployees(){
		return new HashSet<>(this.employeeRepository.findAll());
	}
	
	
	public Employee fetchEmployeeById(long employeeId) {
		return this.employeeRepository
					.findById(employeeId)
					.orElseThrow(() -> new IllegalArgumentException("invalid employee id passed.."));
	}
	
	public void deleteEmployeeById(long employeeId) {
		this.employeeRepository.deleteById(employeeId);
	}
	
	public Employee updateEmployee(long employeeId, Employee updatedEmployee) {
		System.out.println("Passed in employee is "+ updatedEmployee);
		System.out.println("Passed employee-id is :: "+ employeeId);
		Employee employeeFromRepository = this.fetchEmployeeById(employeeId);
		employeeFromRepository.setEmail(updatedEmployee.getEmail());
		employeeFromRepository.setfirstName(updatedEmployee.getfirstName());
		employeeFromRepository.setlastName(updatedEmployee.getlastName());
		this.employeeRepository.save(employeeFromRepository);
		return employeeFromRepository;
	}

	
	public List<Employee> fetchAllEmployeesByfirstName(String firstName) {
		return this.employeeRepository.findByfirstName(firstName);
	}

	




}
