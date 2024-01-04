import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-money-transfer-page',
  templateUrl: './money-transfer-page.component.html',
  styleUrls: ['./money-transfer-page.component.css']
})
export class MoneyTransferFormComponent implements OnInit {
  MoneyTransferForm!: FormGroup;
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private userService: UserService) { }

  ngOnInit(): void {
    this.initializeForm();
  }

  isFieldInvalid(fieldName: string): boolean {
    const field = this.MoneyTransferForm.get(fieldName);
    return field?.invalid && (field?.touched || field?.dirty) || false!;
  }

  initializeForm(): void {
    this.MoneyTransferForm = this.fb.group({
      accountnumber: ['', [Validators.required, Validators.pattern(/^\d{1}$/)]],
      recipientaccountnumber: ['', [Validators.required, Validators.pattern(/^\d{1}$/)]],
      transactionammount: ['', [Validators.required]],
      pin: ['', [Validators.required, Validators.minLength(4)]],
      phoneno: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
    });
  }

  onSubmit(): void {
    if (this.MoneyTransferForm.valid) {
      const moneytransfervariable = this.MoneyTransferForm.value;
      this.userService.moneytransfer(moneytransfervariable).subscribe(
        (response: any) => {
          if (response.success === 'true') {
            alert('Money transfer successfully');
            window.location.reload();
          } else {
            this.handleErrorResponse(response.message);
          }
        },
        (error) => {
          console.error('Money transfer failed:', error);
          this.handleErrorResponse('An error occurred during money transfer');
        }
      );
    }
  }

  private handleErrorResponse(message: string): void {
    console.log('Received error message:', message);
  
    // Display the actual error message in the UI
    this.errorMessage = `Error: ${message}`;
  }
  
  
}
