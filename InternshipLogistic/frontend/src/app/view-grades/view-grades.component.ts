import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from '@angular/core';
import { map } from "rxjs/operators";
import { Student } from "../model/Student";
import {Grade} from "../model/Grade";
import {ViewGradesService} from "../services/view-grades.service";


@Component({
  selector: 'app-view-grades',
  templateUrl: './view-grades.component.html',
  styleUrls: ['./view-grades.component.css']
})
export class ViewGradesComponent implements OnInit  {

  selectedStudent = new Student("Student20", "email20", false);
  grades: any[] = [];
  constructor(private http: HttpClient, private ViewGradesService:ViewGradesService) {
  }

  ngOnInit() {
    this.ViewGrades();
  }
  private ViewGrades()
  {
    this.ViewGradesService.ViewGrades(this.selectedStudent)
      .pipe(
        map((res:Grade[])=>
        {
          return res.filter((grades:Grade)=>Object.keys(grades).length>1);
        })

      )
      .subscribe((
        filteredGrades:Grade[])=>
      {
        this.grades=filteredGrades;
        console.log(filteredGrades);
      });

  }


}
