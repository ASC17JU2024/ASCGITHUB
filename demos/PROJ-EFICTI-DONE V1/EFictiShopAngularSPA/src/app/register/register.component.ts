import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm : FormGroup;
  submitted = false;
  constructor(private formBuilder : FormBuilder, private router:Router) { }

  ngOnInit(): void {
   const emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";
   const phoneNumber = "^(\+\d{1,3}[- ]?)?\d{10}$";
    this.registerForm = this.formBuilder.group({
      adminName : ['admin',[Validators.required,Validators.minLength(4),Validators.maxLength(20)]],
      email: ['a@a.com', [Validators.required, Validators.email, Validators.pattern(emailPattern)]],
      phone : ['1111111111', [Validators.required,  Validators.pattern("^((\\+65-?)|0)?[0-9]{10}$")]],
      password: ['passpass', [Validators.required, Validators.minLength(6)]]
    })
  }
   // convenience getter for easy access to form fields
   get f() { return this.registerForm.controls; }

   onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      alert('invalid')
        return;
    }
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value))
    this.router.navigate(['login'])
}
}
