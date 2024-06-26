:keyboard: **Lab 9 - REST API**  


:lock: **User Story** The Employee Controller is currently fetching the details of employees from the database. It shoud save new records, update and delete existing records, search records based on 
the employeeid or salary. Explore postman/swagger/curl (any tool of your choice) to perform the operations.

```java
package com.demo.controller;

import com.demo.entity.EmployeeEntity;
import com.demo.model.EmployeeModel;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.Function;


@RestController
@RequestMapping("/api/v1")
public class EmployeeControllerDbRepo {
    @Autowired
private EmployeeRepository employeeRepository;
    @GetMapping("/employee")
    public EmployeeModel getEmployee() {
        EmployeeModel employeeModel = new EmployeeModel(1,"Ben",5000);
        return employeeModel;
    }
    @GetMapping("/employees")
    public List<EmployeeEntity> getEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        return employeesList;
    }
    @GetMapping("/employeeMap")
    public Map getEmployeeMap() {
        Map<Integer,EmployeeModel> employeeMap = new TreeMap<>();
        employeeMap.put(5, new EmployeeModel(5, "JumboJets", 55));
        employeeMap.put( 5555,new EmployeeModel(5555, "JumboJets", 55));
//		return "{id : 1}";
        return employeeMap;
    }
    @GetMapping("/employeesHTML")
    public String getEmployeeHTML() {
       return  "<?xml version=\"1.0\"?>\n" +
                "<html><head><title>Employees</title></head><body><table style=\"border:2px solid green\"><thead><tr style=\"border:1px solid red\"><th>Employee Id </th><th>Name</th><th>Salary</th></tr><tr><td>1</td><td>Ben</td><td>5000</td></tr><tr><td>2</td><td>Sam</td><td>6000</td></tr></thead></table></body></html>";

    }
}

```
