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

 

  constructor(private fb: FormBuilder,private userService: UserService) { }//yat quama deun private userService: UserService hi file user.service.ts import keli 

  ngOnInit(): void {
    this.initializeForm();
  }

  get registerButtonColor(): string {
    return this.MoneyTransferForm.valid ? '#2d6a4f' : '#b7e4c7';
  }

  initializeForm(): void {
    this.MoneyTransferForm = this.fb.group({
      accountnumber: ['', [Validators.required, Validators.pattern(/^\d{1}$/)]],
      recipientaccountnumber:['', [Validators.required, Validators.pattern(/^\d{1}$/)]],
      transactionammount:['', [Validators.required]],
      date: ['', Validators.required],
      pin: ['', [Validators.required, Validators.minLength(4)]],
      phoneNo: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      
      
    });
  }
    

  //ikde form submit sathi method karftoy money transfer jevha pn form submit hoil tevha hi method call hoil    
  
  
  onSubmit(){
      if(this. MoneyTransferForm.valid){
            
        const moneytransfervariable= this.MoneyTransferForm.value; // userService.ts madhe ek observable use kelya tyachasathi apn .subscribe use karto
        this.userService.moneytransfer(moneytransfervariable).subscribe(
        
    
          (response:any)=>  {
                   if (response.success){
                    console.log("Money transfer successfully",response.message);
                    alert(
                      "Money transfer successfully"
                    );
                    window.location.reload();
                   } else{
                     
                     console.log("failed to transfer",response.message);
                     alert(
                      "failed to transfer amount"
                     )

                   }

          }



        )  
       
      }

     }

































}

  
