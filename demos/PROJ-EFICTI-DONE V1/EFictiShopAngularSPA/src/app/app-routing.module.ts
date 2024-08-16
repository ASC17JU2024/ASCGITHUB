import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AddEmpSbComponent } from "./add-emp-sb/add-emp-sb.component";
import { AddEmpComponent } from "./add-emp/add-emp.component";
import { ListEmpSbComponent } from "./list-emp-sb/list-emp-sb.component";
import { ListEmpComponent } from "./list-emp/list-emp.component";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";
import { AuthGuardService } from "./service/auth-guard.service";
import { UpdateEmpSbComponent } from "./update-emp-sb/update-emp-sb.component";
import { UpdateEmpComponent } from "./update-emp/update-emp.component";


const configuredRoutes : Routes = [
    // localhost:4200 (localhost:4200/employees)
    // {path : '', redirectTo: 'login', pathMatch: 'full'},
    {path: '', component:LoginComponent},
    {path: 'login', component:LoginComponent},
    {path: 'register', component:RegisterComponent},
    // employees = load ListEmpComponent
    {path: 'employees', component:ListEmpComponent, canActivate:[AuthGuardService]},
    {path: 'employees-sb', component:ListEmpSbComponent, canActivate:[AuthGuardService]},
    {path: 'add', component:AddEmpComponent, canActivate:[AuthGuardService]},
    {path: 'add-sb', component:AddEmpSbComponent, canActivate:[AuthGuardService]},
    {path: 'update/:id', component:UpdateEmpComponent, canActivate:[AuthGuardService]},
    {path: 'update-sb/:id', component:UpdateEmpSbComponent, canActivate:[AuthGuardService]},
    {path: '**', component:LoginComponent},
]

@NgModule({
    //AppRoutingModule is using the RouterModule
    //import it / configure it
    imports: [RouterModule.forRoot(configuredRoutes)],
    // export RouterModule / used by other modules / outside AppRoutingModule
    exports: [RouterModule]
})
export class AppRoutingModule {}