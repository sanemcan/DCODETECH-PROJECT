import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-transaction-history',
  templateUrl: './transaction-history.component.html',
  styleUrls: ['./transaction-history.component.css']
})
export class TransactionHistoryComponent implements OnInit {
  txnhistory!: FormGroup;
  transactionData: any; // Add a variable to store transaction history data

  constructor(private fb: FormBuilder, private userService: UserService) { }

  ngOnInit(): void {
    this.initializeForm();
  }

  get viewButtonColor(): string {
    return this.txnhistory.valid ? '#2d6a4f' : '#b7e4c7';
  }

  initializeForm(): void {
    this.txnhistory = this.fb.group({
      accid: ['', Validators.required],
      // pin: ['', Validators.required],
    });
  }

  viewTransactionHistory(): void {
    if (this.txnhistory.valid) {
      const accountId = this.txnhistory.value.accid;

      // Call the UserService method to get transaction history
      this.userService.getTxnHistory(accountId).subscribe(
        (data) => {
          // Handle the retrieved transaction history data
          this.transactionData = data;
          console.log('Transaction History:', this.transactionData);
          // You can further process or display the data as needed in your component
        },
        (error) => {
          console.error('Error fetching transaction history:', error);
          // Handle the error appropriately, e.g., display an error message to the user
        }
      );
    }
  }
}
