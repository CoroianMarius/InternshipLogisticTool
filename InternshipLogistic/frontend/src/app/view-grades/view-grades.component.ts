import {Component} from '@angular/core';
import {STUDENTS} from "../student_lists";

@Component({
  selector: 'app-view-grades',
  templateUrl: './view-grades.component.html',
  styleUrls: ['./view-grades.component.css']
})
export class ViewGradesComponent {
  student = STUDENTS;
}
