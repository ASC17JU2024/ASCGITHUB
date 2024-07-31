:books: **Building RESTAPI CRUD Application**  

:green_book: **1 SETTING UP THE PROJECT**  


:beginner: _**Create a maven project**_  
Name : ld-sb-rest-jpa-hib-crud-mvn  
Jdk : 1.8  
Archetype : org.apache.maven.> archetypes:maven-archetype-quickstart  
>    Advanced Settings :     
>        Group Id : com.ld   
        Artifact Id : ld-sb-rest-jpa-hib-crud-mvn


:beginner: _**Configure Spring Boot Project**_  

:point_right: Add spring boot manven dependencies  

:one:  inside `<project>`
```xml
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.8</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
```
:two: _iniside `<dependencies>`_
```xml
   <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter</artifactId>
    </dependency>
```
```xml
		<!-- Build web, including RESTful, applications using Spring MVC. Uses 
			Apache Tomcat as the default embedded container. -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```
```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
```
```xml
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
    </dependency>
```
```xml
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
      </dependency>
```
:three:  inside `<project>`
```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```

:green_book: **2 CONFIGURE APPLICATION PROPERTIES**  
- "src/main/resources/application.properties"  

```properties
spring.datasource.url = jdbc:mysql://localhost:3306/SBDB1?useSSL=false
spring.datasource.username = root
spring.datasource.password = mysql

## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

# Hibernate ddl auto (create, create-drop, validate, update)
#update = creates table once / updates it next
spring.jpa.hibernate.ddl-auto = update

# For Web app and tomcat server
server.servlet.context-path=/ema
server.port=9090
```

:green_book: **3 CREATING THE MODEL**  
```java
package com.demo.model;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}
}
```

:green_book: **4 CREATE THE ENTITY**  

```java
package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name="LAST_NAME", nullable = false) 
	private String lastName;
	@Column(name="EMAIL_ADDRESS", nullable = false)
	private String emailId;

	// default cons
	public Employee() {

	}

	public Employee(Long id, String firstName, String lastName, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}

}


```
:green_book: **5 CREATE THE REPOSITORY**  
```java
package com.demo.repository;

import com.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
}

```

:green_book: **6 CREATE THE CONTROLLER**  
```java
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
}

```

:green_book: **7 CONFIGURE THE SPRINGBOOT APP**  
```java
package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}

```

:green_book: **8 SQL SCRIPTS**  

```sql
CREATE DATABASE SBDB1;
use SBDB1;
SELECT * FROM EMPLOYEES;
INSERT INTO EMPLOYEES VALUES(1,'N@N.COM','Nishant','N');
INSERT INTO EMPLOYEES VALUES(2,'a@a.COM','Awez','N');
```

:green_book: **9 TEST**  
```sh
http://localhost:8080/api/employees
```
```json
[
{
"id": 1,
"firstName": "rambo",
"lastName": "john",
"emailId": "r@r.com"
},
{
"id": 2,
"firstName": "rambo2",
"lastName": "john2",
"emailId": "r2@r.com"
}
]
```








