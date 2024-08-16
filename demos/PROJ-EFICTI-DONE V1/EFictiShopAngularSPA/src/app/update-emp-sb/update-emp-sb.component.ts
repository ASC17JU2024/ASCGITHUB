import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/employee.model';
import { EmployeeSbService } from '../service/employee-sb.service';

@Component({
  selector: 'app-update-emp-sb',
  templateUrl: './update-emp-sb.component.html',
  styleUrls: ['./update-emp-sb.component.css']
})
export class UpdateEmpSbComponent implements OnInit {
  id:number;
  employee: Employee;
  constructor(private employeeSbService: EmployeeSbService, private route : ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    // this.id = 5;
    this.id = this.route.snapshot.params['id'];
    this.employee = new Employee();
    this.employeeSbService.getEmployeeById(this.id)
    .subscribe(searchedEmployee => {
      console.log(searchedEmployee)
      this.employee = searchedEmployee;
    }, error => console.log(error))
  }
  updateEmployee() {
    this.employeeSbService.updateEmployee(this.id,this.employee)
    .subscribe(data => console.log(data), error => console.log(error));
    this.employee = new Employee();
    this.router.navigate(['/employees-sb']);
  }
}


