import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from '@angular/core';
import { map } from "rxjs/operators";
import { Student } from "../model/Student";
import { ViewAttendenceService } from "../services/view-attendence.service";
import { Attendance } from "../model/Attendance";

@Component({
  selector: 'app-view-attendence',
  templateUrl: './view-attendence.component.html',
  styleUrls: ['./view-attendence.component.css']
})
export class ViewAttendenceComponent implements OnInit {
  selectedStudent = new Student("Student20", "email20", false);
  attendance: any[] = [];

  constructor(private http: HttpClient, private viewAttendenceService: ViewAttendenceService) {
  }

  ngOnInit() {
    this.viewAttendence();
  }

  private viewAttendence() {
    this.viewAttendenceService.ViewAttendence(this.selectedStudent)
      .pipe(
        map((res: Attendance[]) => {
          // Filter out the tuples with non-empty data
          return res.filter((attendance: Attendance) => Object.keys(attendance).length > 1);
        })
      )
      .subscribe((filteredAttendance: Attendance[]) => {
        this.attendance = filteredAttendance;
        console.log(filteredAttendance);
      });
  }

}
