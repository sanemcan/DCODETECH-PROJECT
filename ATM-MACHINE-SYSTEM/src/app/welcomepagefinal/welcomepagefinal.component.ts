import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-welcomepagefinal',
  templateUrl: './welcomepagefinal.component.html',
  styleUrls: ['./welcomepagefinal.component.css']
})
export class WelcomepagefinalComponent {


  constructor(private router: Router, private elementRef: ElementRef) { }

  navigateToFeatures() {
    const atmFeaturesElement = this.elementRef.nativeElement.querySelector('#atm-features');
    if (atmFeaturesElement) {
      atmFeaturesElement.scrollIntoView({ behavior: 'smooth' });
    }
  }

  navigateToLogin(): void {
    this.router.navigate(['/login']);
  }

  navigateToRegister(): void {
    this.router.navigate(['/register']);
  }


}
