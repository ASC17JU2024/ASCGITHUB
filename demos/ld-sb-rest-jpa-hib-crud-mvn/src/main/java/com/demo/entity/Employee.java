package com.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
@Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
@Column(name = "LAST_NAME", nullable = false)
    private String lastName;
@Column(name = "EMAIL_ADDRESS", nullable = false)
    private String emailId;

    // default constructor
    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}