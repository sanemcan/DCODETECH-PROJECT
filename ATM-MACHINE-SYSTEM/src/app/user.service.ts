import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  createAccount(accountData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/api/createAccount`, accountData);
  }

  updatePin(accountid: String): Observable<String> {

    const body = { accountid };
    return this.http.post<String>(`${this.apiUrl}/pinchange`, accountid);

  }

}
