import { Component } from '@angular/core';
import {Student} from "../model/Student";
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-menu-leader',
  templateUrl: './menu-leader.component.html',
  styleUrls: ['./menu-leader.component.css']
})
export class MenuLeaderComponent {
  constructor(private route: ActivatedRoute) {}
  logedin?:string;

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      const userName = params['name'];
      const userEmail = params['email'];
      // Use the user's name and email as needed
    });
  }

}
