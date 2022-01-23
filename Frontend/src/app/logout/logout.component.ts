import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { NotificationService } from '../services/notification.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authService: AuthenticationService,  private router: Router, private toastr : NotificationService) { }

  showToasterSuccess(){
    this.toastr.showSuccess("Logout Successful", "Notification!!")
}

  ngOnInit(): void {

    this.authService.logout();
    this.router.navigate(['/dashboard']);
    this.showToasterSuccess();
  }

}
