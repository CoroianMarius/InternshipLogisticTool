import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';

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



}
