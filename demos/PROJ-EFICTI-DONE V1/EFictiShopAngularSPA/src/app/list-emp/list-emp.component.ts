import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee.model';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-list-emp',
  templateUrl: './list-emp.component.html',
  styleUrls: ['./list-emp.component.css']
})
//life-cycle hooks (initialization)
export class ListEmpComponent implements OnInit {
  employees?: Employee[];
  employeeService: EmployeeService;
  // instantiates the employee service
  constructor(employeeService: EmployeeService, private router:Router) {
    this.employeeService = employeeService;
  }
  // populates the data into the employees array.
  ngOnInit(): void {
    //inintialize
    this.employeeService.getEmployees().subscribe(
      (employeeData) => { this.employees = employeeData }
    );
  }
  deleteEmployee(toDeleteEmployee : Employee) : void {
    this.employeeService.deleteEmployee(toDeleteEmployee.id).subscribe(
      (data)=> {
        // remove from array
        this.employees = this.employees.filter((employee) => employee != toDeleteEmployee )
      }
    )
  }
  updateEmployee(id :number) {
    //navigate to update emp comp
    this.router.navigate(['update',id]);
  }
}
