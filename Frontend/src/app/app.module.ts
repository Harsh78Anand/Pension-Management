import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { PensionerInputComponent } from './pensioner-input/pensioner-input.component';
import { ProcessPensionInputComponent } from './process-pension-input/process-pension-input.component';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './dashboard/dashboard.component'
import { RouterModule } from '@angular/router';
import { PensionDetailComponent } from './pension-detail/pension-detail.component';
import { SuccessComponent } from './success/success.component';
import { ErrorComponent } from './error/error.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LogoutComponent } from './logout/logout.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PensionerInputComponent,
    ProcessPensionInputComponent,
    DashboardComponent,
    PensionDetailComponent,
    SuccessComponent,
    ErrorComponent,
    NavBarComponent,
    LogoutComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      timeOut: 2000,
      positionClass: 'toast-top-right',
      preventDuplicates: false,
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
