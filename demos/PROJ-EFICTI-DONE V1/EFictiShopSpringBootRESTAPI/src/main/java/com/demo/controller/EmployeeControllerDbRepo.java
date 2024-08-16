package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeControllerDbRepo {
// Dependency Injection (spring framework creates the Repository internally and injects the instance into your app
	@Autowired
	private EmployeeRepository employeeRepository;


	@GetMapping("/employees")
	public List getEmployeeList() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable(value="id") Integer id) {
		Employee existingEmployee = employeeRepository.findById(id).get();
		return existingEmployee;
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable(value="id") Integer id, @RequestBody Employee employee) {
		// fetch the employee
		Employee existingEmployee = employeeRepository.findById(id).get();
		existingEmployee.setName(employee.getName());
		existingEmployee.setSalary(employee.getSalary());
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}
	@DeleteMapping("/employees/{id}")
	public Employee deleteEmployeeById(@PathVariable(value="id") Integer id) {
		Employee existingEmployee = employeeRepository.findById(id).get();
	    employeeRepository.delete(existingEmployee);
		return existingEmployee;
	}
//	@DeleteMapping("/employees/{id}")
//	public Map<String,Boolean> deleteEmployeeById(@PathVariable(value="id") Integer id) {
//		Employee existingEmployee = employeeRepository.findById(id).get();
//	    employeeRepository.delete(existingEmployee);
//	    Map<String, Boolean> response = new HashMap<>();
//	    response.put("deleted", Boolean.TRUE);
//		return response;
//	}
}
