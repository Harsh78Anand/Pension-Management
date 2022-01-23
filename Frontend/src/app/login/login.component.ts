import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../models/User';
import { AuthenticationService } from '../services/authentication.service';
import { NotificationService } from '../services/notification.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;
  msg ="";
  @ViewChild('loginForm', { static: true })
  loginForm!: NgForm;
  constructor(private authService: AuthenticationService,  private router: Router, private toastr : NotificationService) { 

    this.user = {
      userName: "",
      password: ""
    }
    
  }

  ngOnInit(): void {
  }
  showToasterSuccess(){
    this.toastr.showSuccess("Login Successful", "Notification!!")
}
 showToasterError(){
   this.toastr.showError("Invalid Credentials","Error!!");
 }

  onLoginSubmit(){
    this.authService.login(this.user).subscribe(
      response => {
        localStorage.setItem("token", response);
        this.router.navigate(['/dashboard']);
        this.showToasterSuccess();

      },
      error => {
        console.log(error);
        this.showToasterError();
        this.msg = "Invalid Credentitals";
        this.router.navigate(['/login']);
      }
    )
  }

}
