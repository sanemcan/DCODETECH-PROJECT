import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-account-creation-page',
  templateUrl: './account-creation-page.component.html',
  styleUrls: ['./account-creation-page.component.css']
})
export class AccountCreationPageComponent implements OnInit {
  accountCreationForm!: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.initializeForm();
  }

  get registerButtonColor(): string {
    return this.accountCreationForm.valid ? '#2d6a4f' : '#b7e4c7';
  }

  initializeForm(): void {
    this.accountCreationForm = this.fb.group({
      accountType: ['', Validators.required],
      bankName: ['', Validators.required],
      firstName: ['', Validators.required],
      middleName: ['', Validators.required],
      lastName: ['', Validators.required],
      dateOfBirth: ['', Validators.required],
      age: [''],
      phoneNo: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      email: ['', [Validators.required, Validators.email]],
      aadharCardNo: ['', [Validators.required, Validators.pattern(/^\d{12}$/)]],
      pin: ['', [Validators.required, Validators.minLength(4)]],
      passportPhotograph: ['', Validators.required]
    });

    // EVENT LISTNER TO CALCULATE AGE FROM DOB
    this.accountCreationForm.get('dateOfBirth')!.valueChanges.subscribe(() => {
      this.calculateAge();
    });
  }

  calculateAge(): void {
    const birthDate = this.accountCreationForm.get('dateOfBirth')!.value;
    if (birthDate) {
      const today = new Date(); //current date deto with year and month
      const dob = new Date(birthDate);
      const age = today.getFullYear() - dob.getFullYear();  //current year aani birth year minus kela

      // Check if the birthday has occurred this year
      if (today.getMonth() < dob.getMonth() || (today.getMonth() === dob.getMonth() && today.getDate() < dob.getDate())) {
        this.accountCreationForm.get('age')!.setValue(age - 1);
      } else {
        this.accountCreationForm.get('age')!.setValue(age);
      }
    }
  }
}
