import { Component } from '@angular/core';

@Component({
  selector: 'app-menu-mentor',
  templateUrl: './menu-mentor.component.html',
  styleUrls: ['./menu-mentor.component.css']
})
export class MenuMentorComponent {
  showFiller = false;
  selectedComponent: string = '';

  showComponent(componentName: string) {
    this.selectedComponent = componentName;
  }
}
