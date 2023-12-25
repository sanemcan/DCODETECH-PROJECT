import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-transaction-history',
  templateUrl: './transaction-history.component.html',
  styleUrls: ['./transaction-history.component.css']
})
export class TransactionHistoryComponent implements OnInit{
  txnhistory!:FormGroup;

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
      pin: ['', Validators.required],
    });
}
}