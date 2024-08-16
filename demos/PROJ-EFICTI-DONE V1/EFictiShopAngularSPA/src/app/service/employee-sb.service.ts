import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeSbService {
  baseUrl: string = "http://localhost:8080/api/v1/employees";
  constructor(private httpClient: HttpClient) {
  }
  getEmployees() {
    // get
    return this.httpClient.get<Employee[]>(this.baseUrl);;
  }
  getEmployeeById(id: number) {
    //get
    return this.httpClient.get<Employee>(this.baseUrl + "/" + id);;
  }
  createEmployee(employee: Employee) {
    //post : new emp
    return this.httpClient.post(this.baseUrl, employee);
  }
  updateEmployee(id:number, employee:any) : Observable<Object> {
    //put : update emp
    return this.httpClient.put(`${this.baseUrl}/${id}`, employee);
  }
  deleteEmployee(id: number) {
    //post
    return this.httpClient.delete<Employee>(this.baseUrl + "/" + id);
  }
}
