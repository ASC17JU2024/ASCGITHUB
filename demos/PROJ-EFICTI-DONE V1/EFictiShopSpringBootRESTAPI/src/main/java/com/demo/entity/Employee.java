package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Model mapped to a row in the table. [ORM]
@Entity
// Employee > EMPLOYEES
@Table(name="EMPLOYEES")
public class Employee {
//	Uniqueness
	@Id
//	Auto gen Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	id > EMPLOYEE_ID
	@Column(name="EMPLOYEE_ID")
	private Integer id;
	@Column(name="FIRST_NAME", nullable = false)
	private String name;
	private int salary;

	public Employee() {
	}
	
	public Employee(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}