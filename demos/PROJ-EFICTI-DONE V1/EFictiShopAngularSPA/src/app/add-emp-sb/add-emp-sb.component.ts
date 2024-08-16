import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeSbService } from '../service/employee-sb.service';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-add-emp-sb',
  templateUrl: './add-emp-sb.component.html',
  styleUrls: ['./add-emp-sb.component.css']
})
export class AddEmpSbComponent implements OnInit {
  addForm? : FormGroup;
  constructor(private formBuilder: FormBuilder,
   private employeeSbService: EmployeeSbService) {

  }
  ngOnInit(): void {
   this.addForm = this.formBuilder.group({
    id : [0],
    name:[],
    salary:[]
   });
  }
 saveEmployee() {
  console.log('Employee details sent to server..');
  console.log(this.addForm.value);
   this.employeeSbService.createEmployee(this.addForm.value)
   .subscribe((data) => {
    console.log('data saved ', data)
   })
 }
}