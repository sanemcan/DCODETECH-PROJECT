import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  showProfileBox: boolean = false;

  constructor(private router: Router){}

  toggleProfileBox(): void {
    this.showProfileBox = !this.showProfileBox;
  }

  goToHome(): void {
    this.router.navigate(['/dashboard']);
  }
}
