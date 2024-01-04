import { Component } from '@angular/core';
import { AuthService } from '../AuthService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profilecard',
  templateUrl: './profilecard.component.html',
  styleUrls: ['./profilecard.component.css']
})
export class ProfilecardComponent {
  user: any;

  constructor(private authService: AuthService,private router: Router) { }

  ngOnInit(): void {
    this.user = this.authService.getUserDetails();
  }

  onLogout():void{
    this.authService.logOut();
    this.router.navigate(['/login']);
  }
}
