import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent {

  constructor(private router: Router) { }

  navigateToAccountCreation(): void {
    this.router.navigate(['/account']);
  }

  navigateToTransactionHistory(): void {
    this.router.navigate(['/transaction']);
  }

  navigateToPhoneNoChange(): void {
    this.router.navigate(['/Changephonenumber']);
  }

  navigateToMoneyTransfer(): void {
    this.router.navigate(['/Moneytransfer']);
  }

  navigateToPinChange(): void {
    this.router.navigate(['/pinchange']);
  }

  navigateToChequeBookReq(): void {
    this.router.navigate(['/chequebookrequest']);
  }
}
