import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup ,Validators } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-change-phone-number-page',
  templateUrl: './change-phone-number-page.component.html',
  styleUrls: ['./change-phone-number-page.component.css']
})
export class ChangePhoneNumberPageComponent implements OnInit {
  changePhoneNumberForm!: FormGroup;
  updatePhn: string | undefined;

  constructor(private fb: FormBuilder,private userService:UserService) { }
  
  ngOnInit(): void {
    this.initializeForm();
  }

  get registerButtonColor(): string {
    return this.changePhoneNumberForm.valid ? '#2d6a4f' : '#b7e4c7';
  }

 

  initializeForm(): void {
    this.changePhoneNumberForm = this.fb.group({
      accountnumber: ['', [Validators.required]],
      previousphoneNo: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      phoneNo: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],     
      pin: ['', [Validators.required, Validators.minLength(4)]],
     
    });
  
  }

  onSubmit(): void {
    if (this.changePhoneNumberForm.valid) {
      const pinChangeData = this.changePhoneNumberForm.value;
      this.userService.updatePhn(pinChangeData).subscribe(
        (response) => {
          this.updatePhn = response;
          alert("Phone No Updated Successfully!")
          window.location.reload();
        },
        (error) => {
          console.error('Error updating Phone No:', error);  
          this.updatePhn = 'Failed to update Phone No';
          alert("Invalid account ID or current pin")
        }
      );
    }
  }
}

