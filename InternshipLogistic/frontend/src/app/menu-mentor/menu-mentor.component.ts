import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../services/auth.service';
import {Student} from "../model/Student";
@Component({
  selector: 'app-menu-mentor',
  templateUrl: './menu-mentor.component.html',
  styleUrls: ['./menu-mentor.component.css']
})
export class MenuMentorComponent {
  showFiller = false;
  selectedComponent: string = '';
  logedin?:string;
selectedMentor:Student;
  showComponent(componentName: string) {
    this.selectedComponent = componentName;
  }
  constructor(private route: ActivatedRoute,private authService: AuthService) {
    this.selectedMentor=this.authService.getLoggedInUser();
    console.log(this.selectedMentor);
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      const userName = params['name'];
      const userEmail = params['email'];
      this.logedin=userName;
      // Use the user's name and email as needed
    });
  }
}
