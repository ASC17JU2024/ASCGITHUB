import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

// Decorator / selector, templateURL, css
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
// OnInit / initialzation > ngOnInit() Lifecycle Hook
export class LoginComponent implements OnInit {
  loginForm : FormGroup;

  constructor(private formBuilder : FormBuilder, private router:Router) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      loginid: ["teddy"],
      password: []
    })
    
  }

  onSubmit() {
    console.log("logging.....");
    console.log(this.loginForm.value);

    const loginid : string = this.loginForm.controls['loginid'].value;
    const password : string = this.loginForm.controls['password'].value;

    if(loginid == 'teddy' && password == 'pass'){
      // this.loginForm.controls['loginid'].setValue("");
      // this.loginForm.controls['password'].setValue("");
      sessionStorage.setItem("loggedIn",'yes')
      this.router.navigate(['employees-sb'])
    }
    else {
      this.loginForm.controls['loginid'].setValue("");
      this.loginForm.controls['password'].setValue("");
      this.router.navigate(['login'])
    }
  }
}
