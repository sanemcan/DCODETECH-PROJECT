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



  constructor(private fb: FormBuilder, private userService: UserService) { }//yat quama deun private userService: UserService hi file user.service.ts import keli 

  ngOnInit(): void {
    this.initializeForm();
  }

  get registerButtonColor(): string {
    return this.MoneyTransferForm.valid ? '#684497' : '#cfbce8';
  }

  initializeForm(): void {
    this.MoneyTransferForm = this.fb.group({
      accountnumber: ['', [Validators.required, Validators.pattern(/^\d{1}$/)]],
      recipientaccountnumber: ['', [Validators.required, Validators.pattern(/^\d{1}$/)]],
      transactionammount: ['', [Validators.required]],
      // date: ['', Validators.required],
      pin: ['', [Validators.required, Validators.minLength(4)]],
      phoneno: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],


    });
  }


  //ikde form submit sathi method karftoy money transfer jevha pn form submit hoil tevha hi method call hoil    


  onSubmit() {
    if (this.MoneyTransferForm.valid) {
      const moneytransfervariable = this.MoneyTransferForm.value;
      this.userService.moneytransfer(moneytransfervariable).subscribe(
        (response: any) => {
          console.log("response",response);
          if (response.success.includes("true")) {
            alert("Money transfer successfully");
            // window.location.reload();
          } else {
            if (response.message.includes("Sender account ID does not exist.")) {
              alert("Sender account ID does not exist");
            } else if (response.message.includes("Recipient account ID does not exist.")) {
              alert("Recipient account ID does not exist");
            } else if (response.message.includes("Incorrect PIN for the sender's account")) {
              alert("Incorrect PIN for the sender's account");
            }
          }
        },
        (error) => {
          console.error("Error during money transfer:", error);
          alert("An error occurred during money transfer");
        }
      );
    }
  }




}


