import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PensionDetail } from '../models/PensionDetail';
import { Pensioner } from '../models/Pensioner';
import { PensionDetailService } from '../services/pension-detail.service';

@Component({
  selector: 'app-pension-detail',
  templateUrl: './pension-detail.component.html',
  styleUrls: ['./pension-detail.component.css']
})
export class PensionDetailComponent implements OnInit {
  pensioner : PensionDetail;
  constructor(private pensionDetailService: PensionDetailService, private dataRoute: ActivatedRoute) { 
    this.pensioner = {
      name: "",
      dateOfBirth: new Date,
      pan: "",
      pensionAmount: 0,
      familyPension: true
    };
  }

  ngOnInit(): void {
    let pensionDetails = this.pensionDetailService.getPensionDetails();
    this.pensioner.name = pensionDetails.name;
    this.pensioner.dateOfBirth = pensionDetails.dateOfBirth;
    this.pensioner.pan = pensionDetails.pan;
    this.pensioner.familyPension = pensionDetails.familyPension;
    this.pensioner.pensionAmount = pensionDetails.pensionAmount;
    
  }

 
}

