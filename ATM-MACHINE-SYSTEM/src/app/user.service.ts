import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://localhost:8081'; 

  constructor(private http: HttpClient) {}

  createAccount(accountData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/api/createAccount`, accountData);  
}

   moneytransfer(transferdata: any): Observable<any>{
      return this.http.post(`${this.apiUrl}/money-transfer`, transferdata); //ikde component cha path ahe post mapping
   }
}
