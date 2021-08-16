import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

import {UserResitrationDetailsDto} from '../models/userResitrationDetailsDto';
import {registrationUrl} from '../config/api';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  constructor(private http: HttpClient) { }

  addUserRegistration(userRegistration: UserResitrationDetailsDto): Observable<UserResitrationDetailsDto> {
    return this.http.post<UserResitrationDetailsDto>(registrationUrl, userRegistration, httpOptions);
  }
}
