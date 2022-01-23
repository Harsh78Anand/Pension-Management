import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ProcessPensionInput } from '../models/ProcessPensionInput';
import { NotificationService } from '../services/notification.service';
import { PensionService } from '../services/pension.service';




@Component({
  selector: 'app-process-pension-input',
  templateUrl: './process-pension-input.component.html',
  styleUrls: ['./process-pension-input.component.css']
})
export class ProcessPensionInputComponent implements OnInit {

  @ViewChild(NgForm) ngForm: NgForm | undefined;
  hits = 0;
  @ViewChild('processForm', { static: true })
  processForm!: NgForm;
  processPensionInput : ProcessPensionInput;
  constructor(private router: Router, private pensionService: PensionService , private toastr : NotificationService) {
    this.processPensionInput = {
      aadhaarNumber: "",
      pensionAmount: 0,
      bankServiceCharge: 0
     
    }
   }

  ngOnInit(): void {
  }
  showToasterError(){
    this.toastr.showError("Invalid Details", "Error!!")
 }
  
 showToasterWarning(){
   this.toastr.showWarning("Too many failed attempts","Warning!!")
 }

  frmSub(frm: NgForm) {
    
    console.log(frm.value)
    this.pensionService.processPension(this.processPensionInput).subscribe(
      response => {
        console.log(response);
        if (response === 10)
          this.router.navigate(['/success']);
        else { 
          this.showToasterError(); 
          this.hits++;
          console.log(this.hits);
          if (this.hits <= 3) {
            this.router.navigate(['/process-pension-input']);
          }
          else {
            this.router.navigate(['/dashboard']);
            this.showToasterWarning();
          }
        }
      },
      error => {
        console.log(error);
        this.showToasterError();
      }
    )
  }

}
