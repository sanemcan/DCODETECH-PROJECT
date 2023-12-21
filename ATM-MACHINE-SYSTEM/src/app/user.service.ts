import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PinChangeComponent } from './pin-change/pin-change.component';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  updatePin(pinChange: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/pinupdate`, pinChange, { responseType: 'text' });
  }
  createAccount(accountData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/api/createAccount`, accountData);
  }

  moneytransfer(transferdata: any): Observable<any> {
    console.log('Transfer Data:', transferdata);
    return this.http.post(`${this.apiUrl}/money-transfer`, transferdata); //ikde component cha path ahe post mapping
  }
}
