import { Component } from '@angular/core';
import{STUDENTS} from "../student_lists";
import {Students} from "../../Students";
@Component({
  selector: 'app-view-team',
  templateUrl: './view-team.component.html',
  styleUrls: ['./view-team.component.css']
})
export class ViewTeamComponent {
 student=STUDENTS;
}
