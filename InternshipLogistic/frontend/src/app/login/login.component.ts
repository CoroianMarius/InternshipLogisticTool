import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from "@angular/forms";
import { AuthService } from '../services/auth.service';
import {Student} from "../model/Student";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  userType!:string;
  constructor(private router: Router, private authService: AuthService) {
    this.userType ='student';
  }

  login(form: NgForm) {
    if (form.valid) {
      const username = form.value.username;
      const password = form.value.password;

      // Perform login logic and determine the user type


      // Navigate to the appropriate component based on the user type
      switch (this.userType) {
        case 'mentor':
          this.router.navigate(['/mentor']);
           const St=new Student("ana",username,false);
          this.authService.setLoggedInUser(St);
          break;
        case 'student':
          this.router.navigate(['/student']);
          const St1=new Student("ana",username,false);
          this.authService.setLoggedInUser(St1);
          break;
        case 'leader':
          this.router.navigate(['/leader']);
          const St2=new Student("ana",username,false);
          this.authService.setLoggedInUser(St2);
          break;
        default:
          // Handle unknown user type or show an error message
          break;
      }
    }
  }
}
