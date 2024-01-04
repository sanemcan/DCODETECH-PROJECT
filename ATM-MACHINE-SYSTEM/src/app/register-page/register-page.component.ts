import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import * as crypto from 'crypto-js'; //import keli password hash sathi ani install keli
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {
  registerform!: FormGroup;
  constructor(private fb: FormBuilder, private userService: UserService,private router: Router) { }

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm(): void {
    this.registerform = this.fb.group({
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  onSubmit(): void {
    if (this.registerform.valid) {
      const registerData = this.registerform.value;

      this.userService.register(registerData).subscribe(
        (response) => {
          if (response.success) {
            alert("Registration Successful Confirmation Email sent!");
            this.router.navigate(['/Login']); 
          } else {
            if (response.message && response.message.includes("Registration failed. Email or username already exists.")) {
              alert("Registration failed. Email or username already exists.");
            } else {
              alert("Registration failed. Please try.");
            }
          }
        },
        (error) => {
          alert("Registration failed. Email or username already exists.");
        }
      );
    }
  }

  goToWelcome():void{
    this.router.navigate(['/welcome']);
  }

  goToLogin():void{
    this.router.navigate(['/login']);
  }


}
