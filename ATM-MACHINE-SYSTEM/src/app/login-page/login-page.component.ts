import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  loginForm!: FormGroup;
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private userService: UserService, private router: Router) { }

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

  onSubmit(): void {
    if (this.loginForm.valid) {
      const { username, password } = this.loginForm.value;
      this.userService.login(username, password).subscribe(
        (response: any) => {
          console.log('Login successful. Received token:', response.token);
          // Save the token to local storage or a secure storage mechanism
          localStorage.setItem('token', response.token);
          localStorage.setItem('username', response.username);
          localStorage.setItem('firstname', response.firstname);
          localStorage.setItem('lastname', response.lastname);
          localStorage.setItem('email', response.email);
          
          this.router.navigate(['/dashboard']);
        },
        (error) => {
          // Handle login failure, show error message, etc.
          console.error('Login failed:', error);
          this.errorMessage = this.extractErrorMessage(error);
        }
      );
    }
  }

  private extractErrorMessage(error: any): string {
    if (error.error && error.error.message) {
      return error.error.message;
    } else if (error.status === 401) {
      return 'Incorrect password or username';
    } else {
      return 'An unexpected error occurred. Please try again later.';
    }
  }


  goToRegister(): void {
    this.router.navigate(['/register']);
  }
}
