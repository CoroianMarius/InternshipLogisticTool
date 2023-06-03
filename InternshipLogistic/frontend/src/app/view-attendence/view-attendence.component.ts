import {HttpClient} from "@angular/common/http";
import {Component, OnInit} from '@angular/core';
import {map} from "rxjs/operators";
import {Student} from "../model/Student";
import {ViewAttendenceService} from "../services/view-attendence.service";
import {Attendance} from "../model/Attendance";
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {ReactiveFormsModule} from '@angular/forms';
import {Grade} from "../model/Grade";


@Component({
  selector: 'app-view-attendence',
  templateUrl: './view-attendence.component.html',
  styleUrls: ['./view-attendence.component.css']
})
export class ViewAttendenceComponent implements OnInit {
  selectedStudent = new Student("Student20", "email20", false);
  attendance: any[] = [];
  dataSource: MatTableDataSource<Attendance>;
  displayedColumns: string[] = ['task', 'presence'];

  constructor(private http: HttpClient, private viewAttendenceService: ViewAttendenceService) {
    this.dataSource = new MatTableDataSource<Attendance>([]);
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
        this.dataSource.data = this.attendance;
        console.log(filteredAttendance);
      });
  }

}
