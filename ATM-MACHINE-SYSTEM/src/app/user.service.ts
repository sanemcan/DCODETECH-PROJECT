import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  // UPDATE PIN
  updatePin(pinChange: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/pinupdate`, pinChange, { responseType: 'text' });
  }

  // CREATE ACCOUNT
  createAccount(accountData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/api/createAccount`, accountData);
  }

  // MONEY TRANSFER
  moneytransfer(transferdata: any): Observable<any> {
    console.log('Transfer Data:', transferdata);
    return this.http.post(`${this.apiUrl}/money-transfer`, transferdata);
  }

  // REGISTER
  register(registerdata: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/atm/register`, registerdata);
  }

  // TRANSACTION HISTORY
  getTxnHistory(accountId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/history/${accountId}`);
  }

  // LOGIN & TOKEN
  login(username: string, password: string): Observable<any> {
    const loginData = { username, password };
    return this.http.post(`${this.apiUrl}/login`, loginData);
  }

  // CHEQUE BOOK REQUEST
  chequeReq(chequereqdata: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/chequebookReq`, chequereqdata);
  }

  // UPDATE PHONE NUMBER
  updatePhn(phnChange: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/NumberUpdate`, phnChange, { responseType: 'text' });
  }
}
