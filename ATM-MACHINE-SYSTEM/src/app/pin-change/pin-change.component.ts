import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-pin-change',
  templateUrl: './pin-change.component.html',
  styleUrls: ['./pin-change.component.css']
})
export class PinChangeComponent implements OnInit {
  pinform!: FormGroup;
  updateStatus: string | undefined;

  constructor(private fd: FormBuilder, private userService: UserService) { }

  ngOnInit(): void {
    this.pinChangeForm();
  }

  get changepinbtn(): string { return this.pinform.valid ? '#2d6a4f' : '#b7e4c7'; }

  pinChangeForm(): void {
    this.pinform = this.fd.group({
      accountnumber: ['', Validators.required],
      cardnumber: ['', Validators.required],
      currentpin: ['', [Validators.required, Validators.minLength(4)]],
      newpin: ['', [Validators.required, Validators.minLength(4)]],
      expdate: ['', Validators.required]
    })
  }


  onSubmit(): void {
    if (this.pinform.valid) {
      const pinChangeData = this.pinform.value;
      this.userService.updatePin(pinChangeData).subscribe(
        (response) => {
          this.updateStatus = response; 
          alert("Pin Updated Successfully!")
          window.location.reload();
        },
        (error) => {
          console.error('Error updating pin:', error);  
          this.updateStatus = 'Failed to update pin';
          alert("Invalid account ID or current pin")
        }
      );
    }
  }
  
  
  
  
}

