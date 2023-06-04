import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-menu-student',
  templateUrl: './menu-student.component.html',
  styleUrls: ['./menu-student.component.css']
})
export class MenuStudentComponent {

  selectedComponent: string = '';

  showComponent(componentName: string) {
    this.selectedComponent = componentName;
  }
  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      const userName = params['name'];
      const userEmail = params['email'];
      // Use the user's name and email as needed
    });
  }


}
