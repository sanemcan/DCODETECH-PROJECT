import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-money-transfer-page',
  templateUrl: './money-transfer-page.component.html',
  styleUrls: ['./money-transfer-page.component.css']
})
export class MoneyTransferFormComponent implements OnInit {
  MoneyTransferForm!: FormGroup;

 

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.initializeForm();
  }

  get registerButtonColor(): string {
    return this.MoneyTransferForm.valid ? '#2d6a4f' : '#b7e4c7';
  }

  initializeForm(): void {
    this.MoneyTransferForm = this.fb.group({
      accountnumber: ['', [Validators.required, Validators.pattern(/^\d{12}$/)]],
      recipientaccountnumber:['', [Validators.required, Validators.pattern(/^\d{12}$/)]],
      transactionammount:['', [Validators.required, Validators.pattern(/^\d{60000}$/)]],
      date: ['', Validators.required],
      pin: ['', [Validators.required, Validators.minLength(4)]],
      phoneNo: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      
      
    });
  }
}

  //   // EVENT LISTNER TO CALCULATE AGE FROM DOB
  //   this.MoneyTransferForm.get('date')!.valueChanges.subscribe(() => {
  //     this.calculateAge();
  //   });
  // }

  // calculateAge(): void {
  //   const birthDate = this.accountCreationForm.get('dateOfBirth')!.value;
  //   if (birthDate) {
  //     const today = new Date(); //current date deto with year and month
  //     const dob = new Date(birthDate);
  //     const age = today.getFullYear() - dob.getFullYear();  //current year aani birth year minus kela

  //     // Check if the birthday has occurred this year
  //     if (today.getMonth() < dob.getMonth() || (today.getMonth() === dob.getMonth() && today.getDate() < dob.getDate())) {
  //       this.accountCreationForm.get('age')!.setValue(age - 1);
  //     } else {
  //       this.accountCreationForm.get('age')!.setValue(age);
  //     }
  //   }
  // }

