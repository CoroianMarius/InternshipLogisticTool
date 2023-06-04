import {HttpClient} from "@angular/common/http";
import {Component, OnInit} from '@angular/core';
import {map} from "rxjs/operators";
import {Student} from "../model/Student";
import {Grade} from "../model/Grade";
import {ViewGradesService} from "../services/view-grades.service";
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-view-grades',
  templateUrl: './view-grades.component.html',
  styleUrls: ['./view-grades.component.css']
})
export class ViewGradesComponent implements OnInit {

  selectedStudent = new Student("Student10", "email10", true);
  grades: Grade[] = [];
  dataSource: MatTableDataSource<Grade>;


  displayedColumns: string[] = ['task', 'mentor', 'grade', 'comment'];

  constructor(private http: HttpClient, private viewGradesService: ViewGradesService) {
    this.dataSource = new MatTableDataSource<Grade>([]);

  }

  ngOnInit() {
    this.viewGrades();


  }

  private viewGrades() {
    this.viewGradesService.ViewGrades(this.selectedStudent)
      .pipe(
        map((res: Grade[]) => {
          return res.filter((grade: Grade) => Object.keys(grade).length > 1);
        })
      )
      .subscribe((filteredGrades: Grade[]) => {
        this.grades = filteredGrades;
        this.dataSource.data = this.grades;
        console.log(filteredGrades);
      });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    console.log((event.target as HTMLInputElement).value);
  }
}
