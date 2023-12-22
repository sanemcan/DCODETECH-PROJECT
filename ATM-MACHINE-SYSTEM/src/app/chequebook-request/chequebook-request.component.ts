import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-chequebook-request',
  templateUrl: './chequebook-request.component.html',
  styleUrls: ['./chequebook-request.component.css']
})
export class ChequebookRequestComponent implements OnInit {
  chequeReqform!: FormGroup;
  constructor(private fd: FormBuilder , private userService: UserService) { }

  ngOnInit(): void {
    this.chequereqform();

  }

  get chequereqbtn(): string { return this.chequeReqform.valid ? '#2d6a4f' : '#b7e4c7'; }


  chequereqform(): void {
    this.chequeReqform = this.fd.group({
      accounttype: ['', Validators.required],
      firstname: ['', Validators.required],

      middlename: ['', Validators.required],
      lastname: ['', Validators.required],
      phoneno: ['', Validators.required],
      emailid: ['', Validators.required],
      date: ['', Validators.required],
      bankname: ['', Validators.required],
      accountnumber: ['', Validators.required],
      pin: ['', Validators.required],
      startingcheque: ['', Validators.required],
      endingcheque: ['', Validators.required],
      leaves: ['', Validators.required],
    })
  }

  onSubmit() {
    if (this.chequeReqform.valid) {
      const cheqreqdata = this.chequeReqform.value;
      this.userService.chequeReq(cheqreqdata).subscribe(
        (response: any) => {
          console.log("response",response);
          if (response.success === true) {
            alert("Request Send  successfully");
            window.location.reload();
          } else {
            alert("Request Failed to Send");
          }
        },
        (error) => {
          console.error("Error during Request:", error);
          alert("An error occurred during Request");
        }
      );
    }
  }
}
