import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee.model';
import { EmployeeSbService } from '../service/employee-sb.service';

@Component({
  selector: 'app-list-emp-sb',
  templateUrl: './list-emp-sb.component.html',
  styleUrls: ['./list-emp-sb.component.css']
})
export class ListEmpSbComponent implements OnInit {
  employees?: Employee[];
  employeeSbService: EmployeeSbService;
  // instantiates the employee service
  constructor(employeeSbService: EmployeeSbService, private router:Router) {
    this.employeeSbService = employeeSbService;
  }
  // populates the data into the employees array.
  ngOnInit(): void {
    //inintialize
    this.employeeSbService.getEmployees().subscribe(
      (employeeData) => { this.employees = employeeData }
    );
  }
  deleteEmployee(toDeleteEmployee : Employee) : void {
    this.employeeSbService.deleteEmployee(toDeleteEmployee.id).subscribe(
      (data)=> {
        // remove from array
        this.employees = this.employees.filter((employee) => employee != toDeleteEmployee )
      }
    )
  }
  updateEmployee(id :number) {
    //navigate to update emp comp
    this.router.navigate(['update-sb',id]);
  }
}
