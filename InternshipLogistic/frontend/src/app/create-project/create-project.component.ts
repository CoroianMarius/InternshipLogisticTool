import { Component } from '@angular/core';
import{PROJECTS
} from "../project_list";

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent {
  projects=PROJECTS;
  addProject()
  {

  }
}
