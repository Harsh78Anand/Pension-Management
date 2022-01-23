import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private url = "http://localhost:8081";

  constructor(private http: HttpClient) { }

  // for logging in the user
  login(credentials: User) {
    return this.http.post(`${this.url}/auth/login`, credentials, {responseType: 'text'});
  }

  // check if user is logged in
  isLoggedIn(){
    let token = localStorage.getItem("token");
    if(token==undefined||token==null||token===''){
      return false;
    }
    else{
      return true;
    }
  }

  logout() {
    localStorage.removeItem('token');
  }

  // get token
  getToken() {
    return localStorage.getItem("token");
  }

}
