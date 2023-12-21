import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { UserService } from '../user.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent  implements OnInit {
   loginForm!: FormGroup;

   constructor(private fb: FormBuilder,private userService:UserService) { }

   ngOnInit(): void {
     this.initializeForm();
   }

   get registerButtonColor(): string {
    return this.loginForm.valid ? '#2d6a4f' : '#b7e4c7';
  }

  initializeForm(): void {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      
    });



}



}

