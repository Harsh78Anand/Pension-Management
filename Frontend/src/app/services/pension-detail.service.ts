import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PensionDetailService {

  pensionDetail: any;

  constructor() { }

  setPensionDetails(details: any){
    this.pensionDetail = details;
  }

  getPensionDetails(){
    return this.pensionDetail;
  }

}
