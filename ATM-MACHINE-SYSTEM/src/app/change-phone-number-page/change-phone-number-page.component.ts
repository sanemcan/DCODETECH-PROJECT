import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup ,Validators } from '@angular/forms';

@Component({
  selector: 'app-change-phone-number-page',
  templateUrl: './change-phone-number-page.component.html',
  styleUrls: ['./change-phone-number-page.component.css']
})
export class ChangePhoneNumberPageComponent implements OnInit {
  changePhoneNumberForm!: FormGroup;
  constructor(private fb: FormBuilder) { }
  
  ngOnInit(): void {
    this.initializeForm();
  }

  get registerButtonColor(): string {
    return this.changePhoneNumberForm.valid ? '#2d6a4f' : '#b7e4c7';
  }

 

  initializeForm(): void {
    this.changePhoneNumberForm = this.fb.group({
      accountnumber: ['', [Validators.required, Validators.pattern(/^\d{12}$/)]],
      previousphoneNo: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      
      phoneNo: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
     
     
      pin: ['', [Validators.required, Validators.minLength(4)]],
     
    });
  
  }
}

