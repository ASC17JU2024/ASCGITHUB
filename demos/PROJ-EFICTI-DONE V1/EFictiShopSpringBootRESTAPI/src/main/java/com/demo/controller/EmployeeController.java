package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;

@RestController
@RequestMapping("/api/v0")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		return "Welcome to Spring Boot REST API!";
	}

	@GetMapping("/getHTMLView")
	public String getEmployeeView() {
//		model / provides data
		Employee employee = new Employee(1,"Sam",500);
		String htmlString = "";
		htmlString += "<!DOCTYPE html>";
		htmlString += "<html lang=\"en\">";
		htmlString += "<head>";
		htmlString += "    <title>Bootstrap forms</title>";
		htmlString += "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">";
		htmlString += "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"";
		htmlString += "        integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\"";
		htmlString += "        crossorigin=\"anonymous\"></script><script>alert(\"welcome \");</script>";
		htmlString += "</head>";
		htmlString += "<body>";
		htmlString += "    <div class=\"container\" style=\"margin:50px;background-color:aquamarine;padding:50px;border-radius: 25px;\">";
		htmlString += "        <h1>Employee Data</h1> <br><br>";
		htmlString += "        <h2>" + employee.getId() + "</h2>";
		htmlString += "        <h2>" + employee.getName() + "</h2>";
		htmlString += "        <h2>" + employee.getSalary() + "</h2>";
		htmlString += "        <pre>Thank you .    <br>. . . Have a wonderful day       !!!! </pre>";
		htmlString += "    </div>";
		htmlString += "</body>";
		htmlString += "</html>;";
		return htmlString;
	}
	@GetMapping("/getHTML")
	public String getHTML() {
		String htmlString = "";
		htmlString += "<!DOCTYPE html>";
		htmlString += "<html lang=\"en\">";
		htmlString += "<head>";
		htmlString += "    <title>Bootstrap forms</title>";
		htmlString += "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">";
		htmlString += "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"";
		htmlString += "        integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\"";
		htmlString += "        crossorigin=\"anonymous\"></script>";
		htmlString += "</head>";
		htmlString += "<body>";
		htmlString += "    <div class=\"container\" style=\"margin:50px;background-color:aquamarine;padding:50px;border-radius: 25px;\">";
		htmlString += "        <h1>Registration Form</h1> <br><br>";
		htmlString += "        <form>";
		htmlString += "            <div>";
		htmlString += "                <div class=\"form-group\">";
		htmlString += "                    <label for=\"emailControl\">Email Id :</label>";
		htmlString += "                    <input type=\"text\" id=\"emailControl\" class=\"form-control\"><br>";
		htmlString += "                </div>";
		htmlString += "                <div class=\"form-group\">";
		htmlString += "                    <label for=\"passwordControl\">Password :</label>";
		htmlString += "                    <input type=\"text\" id=\"passwordControl\" class=\"form-control\"><br><br>";
		htmlString += "                </div>";
		htmlString += "            </div>";
		htmlString += "            <br>";
		htmlString += "            <!-- <pre>";
		htmlString += "            <button class=\"btn btn-success\">Submit</button>    <button class=\"btn btn-info\">Clear</button>";
		htmlString += "        </pre> -->";
		htmlString += "            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button";
		htmlString += "                class=\"btn btn-success\">Submit</button>";
		htmlString += "            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class=\"btn btn-info\">Clear</button>";
		htmlString += "            <br><br>";
		htmlString += "        </form>";
		htmlString += "        <pre>Thank you .    <br>. . . Have a wonderful day       !!!! </pre>";
		htmlString += "    </div>";
		htmlString += "</body>";
		htmlString += "</html>;";
		return htmlString;
	}
	@GetMapping("/employee")
//	marshalled to json
	public Employee getEmployee() {
//		return "{id : 1}";
		return new Employee(5, "JumboJets", 5);
	}
	@GetMapping("/employees")
	public List getEmployeeList() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add( new Employee(5, "JumboJets", 55));
		employeeList.add( new Employee(5555, "JumboJets", 55));
//		return "{id : 1}";
		return employeeList;
	}
	@GetMapping("/employeeMap")
	public Map getEmployeeMap() {
		Map<Integer,Employee> employeeMap = new TreeMap<>();
		employeeMap.put(5, new Employee(5, "JumboJets", 55));
		employeeMap.put( 5555,new Employee(5555, "SpiceJet", 55));
//		return "{id : 1}";
		return employeeMap;
	}
}
