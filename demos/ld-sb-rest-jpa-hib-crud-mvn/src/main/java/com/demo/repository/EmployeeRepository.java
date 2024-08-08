package com.demo.repository;

import com.demo.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
  
    Employee findByEmailId(String emailId);

   Employee findByFirstName(String name);

   Employee findByFirstNameAndEmailId(String name, String email);

   Employee findByFirstNameOrEmailId(String name, String email);

   List<Employee> findAllByOrderByFirstNameAsc();

    List<Employee> findAllByOrderByFirstNameAscLastNameDesc();
}



