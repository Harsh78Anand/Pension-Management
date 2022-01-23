import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { Pensioner } from '../models/Pensioner';
import { ProcessPensionInput } from '../models/ProcessPensionInput';

@Injectable({
  providedIn: 'root'
})
export class PensionService {

  private url = "http://localhost:8080";

  constructor(private http: HttpClient, private router: Router, private authService: AuthenticationService) { }

  getPensionDetail(pensioner: Pensioner) {

    const header = new HttpHeaders({ 
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authService.getToken()
   });

    return this.http.post(`${this.url}/process/pensionDetail`, pensioner, {headers: header})

  }
  //processPensionInput: ProcessPensionInput
  processPension(processPensionInput: ProcessPensionInput) {

    const header = new HttpHeaders({ 
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.authService.getToken()
   });

    return this.http.post(`${this.url}/process/processPension`, processPensionInput, {headers: header})

  }

}
