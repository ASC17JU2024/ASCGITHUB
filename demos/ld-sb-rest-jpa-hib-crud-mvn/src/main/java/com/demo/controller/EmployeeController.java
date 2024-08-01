package com.demo.controller;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
//    IOC Container will create and  inject the EmployeeRepository bean into this field.

    private final EmployeeRepository  employeeRepository;
    @Autowired
    public  EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/employees")
    List<Employee> getAllEmployees() {
      return  employeeRepository.findAll();
    }
    @GetMapping("/getHTMLContent")
    public String getHTMLContent() {
        return "<html><head><title>Welcome</title></head><body><h1 style=\"color:green\">Rest API can also expose HTML Data</h1></body></html>";
    }
}
