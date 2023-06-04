import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {NgForm} from "@angular/forms";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']

})
export class LoginComponent {


  constructor(private router: Router) {}
  userType?:string;

  login(event: Event) {
    event.preventDefault();
    const form = event.target as HTMLFormElement;
    if (form['valid']) {

      const username = form['username'].value;
      const password = form['password'].value;

      // Perform login logic and determine the user type
      this.userType='mentor';

      // Navigate to the appropriate component based on the user type
      switch (this.userType) {
        case 'mentor':
          this.router.navigate(['/mentor'], { queryParams: { username, password } });
          break;
        case 'student':
          this.router.navigate(['/student'], { queryParams: { username, password } });
          break;
        case 'leader':
          this.router.navigate(['/leader'], { queryParams: { username, password } });
          break;
        default:
          // Handle unknown user type or show an error message
          break;
      }
    }
  }


}
