import { Component, OnInit } from '@angular/core';
import { ActivityService } from "../services/activity.service";
import { PROJECTS } from "../project_list";
import {NgForm} from "@angular/forms";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {
  projects = PROJECTS;
  addingActivity : boolean = false;
  formData: any={};

  constructor(private activityService: ActivityService, private http: HttpClient) { }

  ngOnInit() {
    this.getProjects();
  }

  private getProjects() {
    this.activityService.getProjects().subscribe((res) => {
      console.log(res);
      this.projects = res;
    });
  }

  addProject() {
    this.addingActivity= true;
  }
  submitForm(){
    const ActivityName = this.formData.name;
    const Tasks = [];
    this.http.post('http://localhost:8080/api/activity', {name: ActivityName, tasks: []}).subscribe((res)=>
    {
      console.log(res);
    })
  }
}
