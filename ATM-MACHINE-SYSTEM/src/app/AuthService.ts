import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class AuthService {
    constructor() { }

    loggedIn(): boolean {
        const isLoggedIn = !!localStorage.getItem('token');
        // console.log('Is logged in:', isLoggedIn);
        return isLoggedIn;
    }

    logOut(): void {
        localStorage.removeItem('token');
        localStorage.removeItem('username');
        localStorage.removeItem('firstname');
        localStorage.removeItem('lastname');
        localStorage.removeItem('email');
    }

    getUserDetails(): any {
        const username = localStorage.getItem('username');
        const firstname = localStorage.getItem('firstname');
        const lastname = localStorage.getItem('lastname');
        const email = localStorage.getItem('email');

        return {
            username: username,
            firstname: firstname,
            lastname: lastname,
            email: email,
        };
    }
}
