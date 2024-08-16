import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ListEmpComponent } from './list-emp/list-emp.component';
import { AddEmpComponent } from './add-emp/add-emp.component';
import { SingleComponent } from './single.component';
import { UpdateEmpComponent } from './update-emp/update-emp.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { ListEmpSbComponent } from './list-emp-sb/list-emp-sb.component';
import { AddEmpSbComponent } from './add-emp-sb/add-emp-sb.component';
import { UpdateEmpSbComponent } from './update-emp-sb/update-emp-sb.component';
import { RegisterComponent } from './register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListEmpComponent,
    AddEmpComponent,
    SingleComponent,
    UpdateEmpComponent,
    ListEmpSbComponent,
    AddEmpSbComponent,
    UpdateEmpSbComponent,
    RegisterComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }


