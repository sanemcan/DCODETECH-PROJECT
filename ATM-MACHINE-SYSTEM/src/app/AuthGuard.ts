import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './AuthService';

@Injectable({
    providedIn: 'root',
})
export class AuthGuard implements CanActivate {
    constructor(private authService: AuthService, private router: Router) { }

    canActivate(): boolean {
        // console.log('AuthGuard canActivate');
        if (this.authService.loggedIn()) {
            return true; // User is authenticated
        } else {
            this.router.navigate(['/login']);
            return false; // User is not authenticated
        }
    }
}
