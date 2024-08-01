package com.demo.controller;

import com.demo.EmployeeService;
import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api")
public class EmployeeController {
//    IOC Container will create and  inject the EmployeeRepository bean into this field.

    private final EmployeeRepository  employeeRepository;
    private final EmployeeService employeeService;
    @Autowired
    public  EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }
//    @GetMapping("/employees")
//    List<Employee> getAllEmployees() {
//      return  employeeRepository.findAll();
//    }
@GetMapping("/employees")
List<Employee> getAllEmployees() {
    return  employeeService.getAllEmployees();
}

    @GetMapping("/getHTMLContent")
    public String getHTMLContent() {
        return "<html><head><title>Welcome</title></head><body><h1 style=\"color:green\">Rest API can also expose HTML Data</h1></body></html>";
    }
    @GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") Long employeeId){
       return employeeRepository.findById(employeeId).get();
    }

    @DeleteMapping(value = "/employees/{empId}")
    public Employee deleteEmployee(@PathVariable(value="empId") Long employeeId){
        Employee employeeToBeDeleted = employeeRepository.findById(employeeId).get();
        employeeRepository.delete(employeeToBeDeleted);
        return employeeToBeDeleted;
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employeeFromclient){
        return employeeRepository.save(employeeFromclient);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employeeFromClient){
        Employee employeeFromDB = employeeRepository.findById(employeeFromClient.getId()).get();
        employeeFromDB.setFirstName(employeeFromClient.getFirstName());
        employeeFromDB.setLastName(employeeFromClient.getLastName());
        employeeFromDB.setEmailId(employeeFromClient.getEmailId());
        return employeeRepository.save(employeeFromDB);
    }
}
