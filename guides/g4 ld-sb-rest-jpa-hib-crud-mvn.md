:books: **Building RESTAPI CRUD Application**  

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


  

  



