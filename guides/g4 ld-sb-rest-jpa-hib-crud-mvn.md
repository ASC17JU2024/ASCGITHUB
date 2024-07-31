:books: **Building RESTAPI CRUD Application**  

:beginner: _**Create a maven project**_  
Name : ld-sb-rest-jpa-hib-crud-mvn  
Jdk : 1.8  
Archetype : org.apache.maven.> archetypes:maven-archetype-quickstart  
>    Advanced Settings :     
>        Group Id : com.ld   
        Artifact Id : ld-sb-rest-jpa-hib-crud-mvn


:beginner: _**Configure Spring Boot Project**_  

:one: Add spring boot manven dependencies inside `<project>`
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


  

  



