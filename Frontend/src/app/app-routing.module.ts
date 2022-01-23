import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ErrorComponent } from './error/error.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { PensionDetailComponent } from './pension-detail/pension-detail.component';
import { PensionerInputComponent } from './pensioner-input/pensioner-input.component';
import { ProcessPensionInputComponent } from './process-pension-input/process-pension-input.component';
import { SuccessComponent } from './success/success.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent,pathMatch:'prefix'},
  {path: 'pensioner-input', canActivate: [AuthGuard], component: PensionerInputComponent},
  {path: 'process-pension-input', canActivate: [AuthGuard], component: ProcessPensionInputComponent},
  {path: 'dashboard', canActivate: [AuthGuard], component: DashboardComponent},
  {path: 'pension-detail', canActivate: [AuthGuard], component: PensionDetailComponent}, 
  {path: 'success', component: SuccessComponent},
  {path:'',redirectTo:'login' ,pathMatch:'full'},
  {path: '**',component:ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
