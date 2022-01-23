import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Pensioner } from '../models/Pensioner';
import { NotificationService } from '../services/notification.service';
import { PensionDetailService } from '../services/pension-detail.service';
import { PensionService } from '../services/pension.service';

@Component({
  selector: 'app-pensioner-input',
  templateUrl: './pensioner-input.component.html',
  styleUrls: ['./pensioner-input.component.css']
})
export class PensionerInputComponent implements OnInit {


  readonly brdInvalid = '1px solid red'
  readonly brdValid = '1px solid green'
  @ViewChild('pensionerForm', { static: true })
  pensionerForm!: NgForm;
  pensioner : Pensioner;
  msg="";
  constructor(private pensionDetailService: PensionDetailService,  private router: Router, private pensionService: PensionService, private toastr:NotificationService) { 
    this.pensioner = {
      name : "",
      dateOfBirth : new Date(""),
      pan : "",
      aadhaarNumber : "",
      familyPension: true
    }
  }
  
  ngOnInit(): void {

  }
  showToasterSuccess(){
    this.toastr.showSuccess("Success", "Notification!!")
}
 showToasterError(){
   this.toastr.showError("Invalid Details","Error!!");
 }
 getToday(): string {
  return new Date().toISOString().split('T')[0]
}

disableDate(){
  return false;
}



  onSubmit() {
    this.pensionService.getPensionDetail(this.pensioner).subscribe(
      response => {
        console.log(response);
        this.pensionDetailService.setPensionDetails(response);
        this.router.navigate(['/pension-detail']);
        this.showToasterSuccess();
      },
      error => {
        console.log(error);
        this.showToasterError();
        console.log(error.error.message);
        if (error.error.message === "Pension details not found") {
          this.router.navigate(['/pensioner-input']);
          
        }
      }
    )
  }

}
